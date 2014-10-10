package com.zxhd.log.util;

import java.io.UnsupportedEncodingException;

import org.apache.mina.common.ByteBuffer;



public class IoBufferUtil {
	
	public static void putString(ByteBuffer buffer, String value){
		if(value == null || value.length() == 0){
			buffer.putInt(0);
			return;
		}
		try {
			byte[] data = value.getBytes("UTF-8");
			int len = data.length;
			buffer.putInt(len);
			buffer.put(data);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public static String getString(ByteBuffer buffer){
		int len = buffer.getInt();
		if(len == 0){
			return null;
		}
		byte[] data = new byte[len];
		buffer.get(data);
		try {
			return new String(data,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	

}
