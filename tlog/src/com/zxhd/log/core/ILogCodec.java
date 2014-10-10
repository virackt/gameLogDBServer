package com.zxhd.log.core;

import java.io.Serializable;

import org.apache.mina.common.ByteBuffer;



public interface ILogCodec extends Serializable{
	
	void encode(ByteBuffer buff);
	
	void decode(ByteBuffer buff);
	
	int getType();
	// 获取日志文件名
	String getFileName();
	// 更新日志内容的sql语句
	String getUpdateSql();
	// 建表sql
	String getCreateTableSql();
	// 获取日志文本内容
	String getFileContent();

}
