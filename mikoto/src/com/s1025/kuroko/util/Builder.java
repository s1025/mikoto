package com.s1025.kuroko.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Builder {
	public static Properties getProperties(String path){
		Properties pps = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(path));
			pps.load(in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pps;
	}
}
