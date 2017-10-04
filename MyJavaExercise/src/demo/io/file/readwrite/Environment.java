package demo.io.file.readwrite;

import java.util.Map;
import java.util.Map.Entry;
/**
 * 环境变量使用范例
 * @author Frank
 */

public class Environment {
	public static void main(String[] args) {
		Map<String, String> env=System.getenv();
		for(Entry<String, String> entry:env.entrySet()){
			System.out.print("key:"+entry.getKey()+"\t\t");
			System.out.println("value:"+entry.getValue());
		}
		String s=System.getenv("JAVA_HOME");
		System.out.println(s);
	}

}
