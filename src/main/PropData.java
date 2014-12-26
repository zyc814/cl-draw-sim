package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropData {
	
	static String path = new String("res/teams.properties");
	
	public static void writeProp(String key, String value) {
		Properties prop = new Properties();
		File file = new File(path);
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

}
