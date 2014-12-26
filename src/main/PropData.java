package main;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropData {
	
	public static String path = new String("res/teams.properties");
	public static Properties prop = new Properties();
	public static File file = new File(path);
	
	public static void writeProp(String key, String value) {
		
		try {
			InputStream fis = new FileInputStream(file);
			prop.load(fis);
			fis.close();
			
			OutputStream fos = new FileOutputStream(path);
			prop.setProperty(key, value);
			prop.store(fos, null);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String readProp(String key) {
		try {
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			prop.load(fis);
			fis.close();
			String value = prop.getProperty(key);
			return value;  
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
