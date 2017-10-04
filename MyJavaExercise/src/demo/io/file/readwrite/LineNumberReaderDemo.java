package demo.io.file.readwrite;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
	//LineNumberReader使用范例
	//按行读取
public class LineNumberReaderDemo {
	public static void main(String[] args) throws IOException {
		File file=new File("E:\\javaworkspace\\MyJavaExercise\\src\\demo\\test\\Test.java");
//		File file =new File("C:\\Users\\Frank\\Desktop\\work\\项目需求：密码IC3\\3.provinces.txt");
		LineNumberReader reader=new LineNumberReader(new FileReader(file));
		String s;
		while((s=reader.readLine())!=null){
			System.out.print(reader.getLineNumber()+"\t:\t");
			System.out.println(s);
			System.out.println(s.length());
//			StringUtils.isNumeric("aaa123456789");
//			byte b='4';
//			if (Character.isDigit(b)){
//				System.out.println("shuzi");
//			}else{
//				System.out.println("zimu");
//			}
//			String str="3sda";
//			if(Character.isDigit(str.getBytes()[0])){
//				System.out.println("shuzi");
//			}else{
//				System.out.println("zimu");
//			}
			
		}
	}
}
