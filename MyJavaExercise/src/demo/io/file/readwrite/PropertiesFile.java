package demo.io.file.readwrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
/*
 * 读写配置文件properties文件
 */
public class PropertiesFile {
	public static void main(String[] args) throws IOException {
		Properties prop =new Properties();
		
		//加载文件
		File input= new File ("config.properties");
		prop.load(new FileInputStream(input));
		//prop.load(new FileReader(input));
		
		//读取
		System.out.println(prop.getProperty("admin_passwd"));
		
		//设置新属性
		prop.setProperty("key", "value");
		
		//输出到新配置文件
		File output=new File("new.properties");
		prop.store(new FileOutputStream(output), "属性列表的描述");
		//prop.store(new FileWriter(output), "属性列表的描述");
	}
}
