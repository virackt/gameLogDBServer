package com.zxhd.log.disruptor;

import com.lmax.disruptor.EventFactory;

public class LogMsgEventFactory implements EventFactory<LogMsgEvent> {

	@Override
	public LogMsgEvent newInstance() {
		return new LogMsgEvent();
	}

}
