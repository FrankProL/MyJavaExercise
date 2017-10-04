package demo.io.file.readwrite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/*
 * 包装类、修饰类
 * 提供方法方便操作
 * buffer提升效率
 */
public class BufferedDemo {
	public static void main(String[] args) throws IOException {
		String dir=System.getProperty("user.dir");	//获取当前工作空间环境变量
		File file=new File(dir+"/src/demo/test/DataStreamDemo.java");
		BufferedReader reader =new BufferedReader(new FileReader(file));
		BufferedWriter writer =new BufferedWriter(new FileWriter("out.txt"));
		
		String line;
		while((line=reader.readLine())!=null){
			writer.write(line);
			writer.write("\r\n");
		}
		writer.flush();
		writer.close();
		reader.close();
	}
}
