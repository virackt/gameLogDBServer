package com.zxhd.log.disruptor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.zxhd.log.util.AppConfig;

public class LogMsgEventUtil {
	private LogMsgEventProducer producer;
	private LogMsgEventUtil() {
		int bufferSize = AppConfig.getIntValue("bufferSize");
		Executor executor = Executors.newCachedThreadPool();
		LogMsgEventFactory factory = new LogMsgEventFactory();
		LogMsgEventHandler	handler = new LogMsgEventHandler();
		Disruptor<LogMsgEvent> disruptor = new Disruptor<LogMsgEvent>(factory, bufferSize, executor, ProducerType.MULTI, new BlockingWaitStrategy());
		disruptor.handleEventsWith(handler);
		disruptor.start();
		RingBuffer<LogMsgEvent> ringBuffer = disruptor.getRingBuffer();
		producer = new LogMsgEventProducer(ringBuffer);
	}
	
	private static LogMsgEventUtil instance;

	public static LogMsgEventUtil getInstance() {
		if (instance == null) {
			instance = new LogMsgEventUtil();
		}
		return instance;
	}

	public void push(String sql) {
		producer.push(sql);
	}
	
}
