package GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String toReadDataFromProp(String key) throws Throwable {
		FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Divya Naik\\eclipse-workspace\\TestNG\\src\\test\\resources\\Components\\rmgyantra.properties");
		Properties prop=new Properties();
		prop.load(fileInputStream);
		String str=prop.getProperty(key);
		return str;
	}
}
