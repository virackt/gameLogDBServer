package com.zxhd.log.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
	private static Properties p;

	public static void init(String fileName) {
		p = new Properties();
		InputStream is;
		try {
			is = new FileInputStream(new File(fileName));
		} catch (FileNotFoundException e) {
			is = AppConfig.class.getResourceAsStream(fileName);
		}
		if (is == null) {
			try {
				is = new FileInputStream("./" + fileName);
			} catch (FileNotFoundException e) {
				is = AppConfig.class.getResourceAsStream("./" + fileName);
			}
		}
		if (is == null) {
			try {
				is = new FileInputStream("/" + fileName);
			} catch (FileNotFoundException e) {
				is = AppConfig.class.getResourceAsStream("/" + fileName);
			}
		}
		try {
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getString(String key) {
		return p.getProperty(key);
	}

	public static String getStringWithDefaultValue(String key,
			String defaultValue) {
		return p.getProperty(key, defaultValue);
	}

	public static int getIntValue(String key) {
		String value = getString(key);
		return Integer.parseInt(value);
	}

}
