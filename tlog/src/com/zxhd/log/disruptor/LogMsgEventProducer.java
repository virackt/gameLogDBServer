package com.zxhd.log.disruptor;


import com.lmax.disruptor.RingBuffer;

public class LogMsgEventProducer {

	private final RingBuffer<LogMsgEvent> ringBuffer;

	public LogMsgEventProducer(RingBuffer<LogMsgEvent> ringBuffer) {
		super();
		this.ringBuffer = ringBuffer;
	}

	public void push(String sql) {
		long sequence = ringBuffer.next();
		try {
			LogMsgEvent event = ringBuffer.get(sequence);
			event.setValue(sql);
			ringBuffer.publish(sequence);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
