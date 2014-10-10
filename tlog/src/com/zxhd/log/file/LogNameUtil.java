package com.zxhd.log.file;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogNameUtil {
	
	public static String getLogName(String className){
		DateFormat df = new SimpleDateFormat("_yyyyMMdd");
		Date d = new Date();
		return className + df.format(d);
	}
	
	public static void main(String[] args){
		System.out.println(getLogName("LoginLog"));
	}
}
