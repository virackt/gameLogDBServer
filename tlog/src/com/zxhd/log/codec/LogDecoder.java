package com.zxhd.log.codec;


import org.apache.mina.common.ByteBuffer;
import org.apache.mina.common.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zxhd.log.core.ILogCodec;
import com.zxhd.log.core.LogMessageTypeConst;

public class LogDecoder extends CumulativeProtocolDecoder {
	private static final Logger log = LoggerFactory.getLogger("decodeLog");

	@Override
	protected boolean doDecode(IoSession session, ByteBuffer buffer,
			ProtocolDecoderOutput output) throws Exception {
		// super.decode(session, buffer, output);
//		buffer.order(ByteOrder.LITTLE_ENDIAN);

		// 消息buf
		
//		buf.order(ByteOrder.LITTLE_ENDIAN);
		// 考虑以下几种情况：
		// 1. 一个ip包中只包含一个完整消息
		// 2. 一个ip包中包含一个完整消息和另一个消息的一部分
		// 3. 一个ip包中包含一个消息的一部分
		// 4. 一个ip包中包含两个完整的数据消息或更多（循环处理在父类的decode中）
		if (buffer.hasRemaining()) {
			buffer.mark();
			int length = buffer.getInt();
			// int length = buffer.getShort(buffer.position());
			if (length < 4) {
				buffer.reset();
				log.error("Error net message. (Message Length=" + length + ")");
				return false;
			}
			if (length > 1024 * 5000) {
				buffer.reset();
				log.error("Error net message. Message Length(" + length + ") > MessageMaxByte(" + 1024 * 5000 + ")");
				return false;
			}
			if (length > buffer.remaining()) {
				buffer.reset();
				log.error("断包了");
				return false;
			}
			// 复制一个完整消息
			byte[] bytes = new byte[length];
			buffer.get(bytes);
			ByteBuffer buf = ByteBuffer.allocate(1024).setAutoExpand(true);
			buf.put(bytes);
			buf.flip();
			int type = buf.getInt();
			ILogCodec msg = LogMessageTypeConst.getLogMsgByType(type);
			if (msg == null) {
				log.error("错误的type：=" + type);
			}
			msg.decode(buf);
			output.write(msg);
			return true;
		} else {
			return false;
		}

		// if (buffer.hasRemaining()) {
		// int len = buffer.getInt();
		// if (len <= 0) {
		// return false;
		// }
		// }
		// if (buffer.hasRemaining()) {
		//
		// int type = buffer.getInt();
		// ILogCodec msg = LogMessageTypeConst.getLogMsgByType(type);
		// if (msg == null) {
		// System.out.println("错误的type：=" + type);
		// }
		// msg.decode(buffer);
		// output.write(msg);
		// finishDecode(session, output);
		// output.flush();
		// }
		// return true;
		// }
	}
}
