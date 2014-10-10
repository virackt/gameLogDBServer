package com.zxhd.log.util;

import java.net.URL;

public class Globals {
	public static String getConfigPathUrl(String fileName){
		URL url = Globals.class.getResource("/");
		return url.getPath() + fileName;
	}
}
