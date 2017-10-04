package demo.io.file.readwrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
	/*
	 * FileReader
	 * 读文件三种方式
	 */
public class ReaderDemo {
	public static void main(String[] args) throws IOException {
		File file=new File("E:\\javaworkspace\\MyJavaExercise\\src\\demo\\io\\file\\readwrite\\Test.java");
		Reader reader=new FileReader(file);
		/* 抽象类和接口不能直接实例化, 不能理解为抽象类型不能有对象，应该理解为抽象类不能直接被new出来，
		 * 它只能通过子类创建出来，jvm判断他是否能被实例时是根据被调用的那个类是否是它的子类来决定的。
		 * Reader-->InputStreamReader-->FileReader
		 * Writer-->OutputStreamWriter-->FileWriter
		 * */
		
		//**************************read()
		int i=reader.read();
		System.out.println(i+" "+ (char)i);
		
		char[] array=new char[200];
		//*************************read(array)
//		while(true){
//			i=reader.read(array);
//			if(i==-1)
//				break;
//			for(int j=0;j<i;j++)
//				System.out.print(array[j]);
//		}
		
		//*************************read(array, off, len)
		int len=-1;
		while((len=reader.read(array, 0, array.length))!=-1){
			for(int j=0;j<len;j++){
				System.out.print(array[j]);
			}
		}
		
		reader.close();	
	}
}
