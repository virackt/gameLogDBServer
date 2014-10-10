package com.zxhd.log.util;

public class LogFileUtil {
	
	public static String convertObjects2String(Object...objects){
		StringBuffer sb = new StringBuffer();
		for(Object obj : objects){
			sb.append(obj);
			sb.append("|");
		}
		String rtStr = sb.toString();
		return rtStr.substring(0, rtStr.length() -1) + "\r\n";
	}
	
	public static void main(String[] args){
		System.out.println(convertObjects2String(111,222,"fff"));
	}

}
