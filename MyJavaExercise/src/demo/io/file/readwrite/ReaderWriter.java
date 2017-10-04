package demo.io.file.readwrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
	/*
	 * 文件读写
	 * 从一个文件读取内容，写到另一个文件
	 * 一边读一边写
	 */
public class ReaderWriter {
	public static void main(String[] args) {
		File file=new File("E:\\javaworkspace\\MyJavaExercise\\src\\demo\\io\\file\\readwrite\\Test.java");
		File wfile=new File("mynewfile");
		
		Reader reader=null;
		Writer writer=null;
		try {
			reader=new FileReader(file);
			writer=new FileWriter(wfile);
			char [] array=new char[200];							//相当于管道，临时的筐，存放读取的数据
			int len=-1;												//控制是否读完
			while((len=reader.read(array, 0, array.length))!=-1){	//读,返回读取的字符数，如果已到达流的末尾，则返回 -1
				
				writer.write(array, 0, len);						//写，最后数组中的数据可能不是满的
			}
			System.out.println("复制成功");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*//不使用try catch，直接使用throws抛出异常
		Reader reader=new FileReader(file);
		Writer writer=new FileWriter(wfile);
		
		int len=-1;
		char [] array=new char[200];
		while((len=reader.read(array, 0, array.length))!=-1){
			writer.write(array, 0, len);
		}
		System.out.println("复制成功");
		reader.close();
		writer.flush();
		writer.close();*/
		
		
		/*//会造成重复写
		Reader reader=new FileReader(file);
		Writer writer=new FileWriter(wfile);
		
		int i=0;
		char [] array=new char[200];
		while(true){
			i=reader.read(array);
			if(i==-1)
				break;
			for(int j=0;j<i;j++){
				System.out.print(array[j]);
				writer.write(array);
			}
		}
		reader.close();
		writer.flush();
		writer.close();*/
	}
}
