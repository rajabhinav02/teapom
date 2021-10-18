package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configreader {
	
	public static Properties pro;

	public Properties getPro() {
		pro = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\resources\\java\\config\\config.properties");
			pro.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pro;
	}
	
}
