package com.zxhd.log.handler;

import org.apache.mina.common.IdleStatus;
import org.apache.mina.common.IoHandler;
import org.apache.mina.common.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zxhd.log.core.ILogCodec;
import com.zxhd.log.disruptor.LogMsgEventUtil;

public class LogServerHandler implements IoHandler {
	private static Logger log = LoggerFactory.getLogger("minaLog");
	private static int num = 0;
	
	@Override
	public void exceptionCaught(IoSession arg0, Throwable arg1)
			throws Exception {
		
	}

	@Override
	public void messageReceived(IoSession arg0, Object obj) throws Exception {
//		System.out.println(arg0);
		if(obj instanceof ILogCodec){
			ILogCodec msg = (ILogCodec)obj;
			num++;
			LogMsgEventUtil.getInstance().push(msg.getUpdateSql());
			
		}
	}

	@Override
	public void messageSent(IoSession arg0, Object arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionClosed(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionCreated(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionIdle(IoSession arg0, IdleStatus arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionOpened(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}


}
