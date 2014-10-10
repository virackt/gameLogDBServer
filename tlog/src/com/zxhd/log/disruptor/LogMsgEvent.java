package com.zxhd.log.disruptor;


public class LogMsgEvent {
	
	private String sql;
	
	public void setValue(String sql){
		this.sql = sql;
	}
	
	public String getValue(){
		return sql;
	}
}
