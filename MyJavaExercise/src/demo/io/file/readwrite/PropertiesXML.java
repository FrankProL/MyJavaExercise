package demo.io.file.readwrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
/*
 * 读写配置文件xml文件
 */
public class PropertiesXML {
	public static void main(String[] args) throws InvalidPropertiesFormatException, FileNotFoundException, IOException {
		Properties prop=new Properties();
		
//		File input=new File("config.xml");
//		prop.loadFromXML(new FileInputStream(input));
		
		prop.setProperty("key", "value");
		
		File output =new File("config.xml");
		prop.storeToXML(new FileOutputStream(output), "属性列表");
	}
}
