package com.zxhd.log.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zxhd.log.core.ILogCodec;
import com.zxhd.log.util.AppConfig;

public class FileWriterUtil {
	private static Logger log = LoggerFactory.getLogger("fileWriterLog");
	
	Charset charset = Charset.forName("UTF-8");
	CharsetDecoder decoder = charset.newDecoder();
	CharsetEncoder encoder = charset.newEncoder();
	private FileWriterUtil() {
	}

	private static FileWriterUtil instance;

	public static FileWriterUtil getInstance() {
		if (instance == null) {
			instance = new FileWriterUtil();
		}
		return instance;
	}

	public void writeLog(ILogCodec msg) {
//		FileInputStream fis = null;
		File file;
		file = new File(AppConfig.getString("filePath") + msg.getFileName()
				+ ".txt");
		FileOutputStream fos = null;
		java.nio.ByteBuffer buff = java.nio.ByteBuffer.allocate(655355535);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
//			fis = new FileInputStream(file);
//			FileChannel fic = fis.getChannel();
//			fic.read(buff);
//			fic.close();
//			fis.close();
			fos = new FileOutputStream(file, true);
			FileChannel foc = fos.getChannel();
			String str = msg.getFileContent();
			log.info(str);
			buff.put(str.getBytes("utf-8"));
			buff.flip();
			CharBuffer cBuff = decoder.decode(buff);
			java.nio.ByteBuffer buffer = encoder.encode(cBuff);
			foc.write(buffer);
			buffer.clear();
			foc.close();
		} catch (Exception e) {
			log.error(e.getMessage());
			log.error("==============Error writing====" + msg.getFileContent());
		} finally{
			try {
				if(buff != null){
					buff.clear();
				}
//				if(fis != null){
//					fis.close();
//				}
				if(fos != null){
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}
	
	public static void main(String[] args){
//		AppConfig.init();
//		FileWriterUtil.getInstance().writeLog(new LoginLogMessage());
	}

}
