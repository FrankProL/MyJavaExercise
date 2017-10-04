package demo.io.file.readwrite;

import java.util.Enumeration;
import java.util.Properties;
import java.util.Map.Entry;

public class SystemProperties {
	public static void main(String[] args) {
		Properties prop = System.getProperties();

		// 列出全部系统属性内容
		for (Entry<Object, Object> entry : prop.entrySet()) {
			System.out.print("key:" + entry.getKey() + "\t");
			System.out.println("value:" + entry.getValue());
		}
		
		//prop.list(System.out);		//该方法也可以列出全部系统属性
		
		//获取指定系统属性内容
		String version =prop.getProperty("java.version");
		System.out.println(version);
		
		//设置系统属性
		setProperty("mykey","myvalue");
		System.out.println(prop.getProperty("mykey", "default"));
		
		//列出全部系统属性名
		Enumeration<String> names=(Enumeration<String>) prop.propertyNames();
		while(names.hasMoreElements()){
			String s=names.nextElement();
			System.out.print(s);
		}
	}
	
	private static void setProperty(String key,String value){
		Properties prop =System.getProperties();
		prop.setProperty(key, value);
	}
}
