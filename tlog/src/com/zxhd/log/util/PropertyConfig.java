package com.zxhd.log.util;

import org.apache.commons.configuration.PropertiesConfiguration;

public class PropertyConfig {
	private static PropertiesConfiguration config;

	public static void init(String fileName) {
		try {
			config = new PropertiesConfiguration(fileName);
			config.setEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getStringValue(String key){
		return config.getString(key);
	}
	
	public static String[] getStringArray(String key){
		return config.getStringArray(key);
	}
	
}
