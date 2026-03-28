package utils;

import java.util.Date;

public class CommonUtils {
	
	public String getEmailWithTimestamp() {
		Date date= new Date();
		return "saripr" + date.toString().replace(" ","_").replace(":", "_")+"@gmail.com";
	}

}
