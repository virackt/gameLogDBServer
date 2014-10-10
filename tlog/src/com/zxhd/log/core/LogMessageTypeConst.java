package com.zxhd.log.core;

import java.util.HashMap;
import java.util.Map;

public class LogMessageTypeConst {
	
	public static Map<Integer, ILogCodec> logMsgMap = new HashMap<Integer, ILogCodec>();
//	static String[] classNames = {"com.zxhd.log.entity.LoginLogMessage", "com.zxhd.log.entity.PvpPkResultLogMessage"};
//	static{
//		logMsgMap.put(LOGIN_LOG, new LoginLogMessage());
//		logMsgMap.put(PVP_PK_LOG, new PvpPkResultLogMessage());
//		
//		
//	}
	
	public static void init(String[] classNames){
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		for(String name : classNames){
			try {
				Class<?> clazz = classLoader.loadClass(name);
//				ILogCodec codec = (ILogCodec)clazz.newInstance();
				registerMessageMap(clazz);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
		}
	}
	
	public static void registerMessageMap(Class<?> codec){
		try {
			ILogCodec msg = (ILogCodec)codec.newInstance();
			logMsgMap.put(msg.getType(), msg);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public static ILogCodec getLogMsgByType(int type){
			return logMsgMap.get(type);
	}
	
}
