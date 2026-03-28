package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	public Properties intializeproperties() {

		Properties prop = new Properties();
		File propfile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.properties");

		try {
			FileInputStream fis = new FileInputStream(propfile);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return prop;
	}

	public Object get(String string) {
		// TODO Auto-generated method stub
		return null;
	}     

}
