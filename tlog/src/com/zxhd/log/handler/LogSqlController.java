package com.zxhd.log.handler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class LogSqlController {
	
	private static LogSqlController instance = new LogSqlController();
	
	private LogSqlController(){
		ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
		
	}
	
	public static LogSqlController getInstance(){
		return instance;
	}
	
	class SQLtASK implements Runnable{

		@Override
		public void run() {
			
		}
		
	}
	
	
	

}
