package com.zxhd.log.file;

import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;


public class FileBufferPoolFactory {
	
	private static ConcurrentHashMap<String, ByteBuffer> fileBufferPool = new ConcurrentHashMap<String, ByteBuffer>();
	
	public static void putNewFileBuffer(String fileName, ByteBuffer buffer){
		fileBufferPool.put(fileName, buffer);
	}
	
	public static ByteBuffer getFileBuffer(String fileName){
		return fileBufferPool.get(fileName);
	}
	
	public static void removeOldFileBuffer(String fileName){
		fileBufferPool.remove(fileName);
	}
	
	
}
