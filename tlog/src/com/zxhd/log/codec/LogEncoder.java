package com.zxhd.log.codec;



import org.apache.mina.common.ByteBuffer;
import org.apache.mina.common.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import com.zxhd.log.core.ILogCodec;

public class LogEncoder implements ProtocolEncoder {

	@Override
	public void dispose(IoSession session) throws Exception {
		if(session != null){
			session.close();
		}
	}

	@Override
	public void encode(IoSession session, Object obj, ProtocolEncoderOutput output)
			throws Exception {
		System.out.println("====================================send");
		if(obj instanceof ILogCodec){
			ILogCodec msg = (ILogCodec)obj;
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			buffer.setAutoExpand(true);
			int oldPosition = buffer.position();
			buffer.skip(4);
			buffer.putInt(msg.getType());
			msg.encode(buffer);
			int len = buffer.position() - 4 - oldPosition;
			buffer.putInt(oldPosition, len);
			buffer.flip();
			output.write(buffer);
			output.flush();
		}
	}

}
