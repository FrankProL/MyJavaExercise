package demo.io.file.readwrite;

import java.io.File;
import java.io.IOException;
/*
 * File 使用入门范例
 */
public class FileDemo {
	public static void main(String[] args) throws IOException {
		//获取系统分隔符
		System.out.println(File.separator);
		//也可以通过系统属性得到
		System.out.println(System.getProperty("file.separator"));
		
		File file=new File("config.xml");
		if(file.isFile()){
			System.out.println(file+"是一个文件");
		}
		
		showFileInformation(file);
		
		createNewFile("newfile.txt");
		
		deleteFile("newfile.txt");
	}

	private static void showFileInformation(File file) {
		// TODO Auto-generated method stub
		System.out.println(file.getAbsolutePath());
		System.out.println(file.canWrite());
		System.out.println(file.getParentFile());
		System.out.println(file.getPath());
		System.out.println(file.getParent());
		System.out.println(file.getAbsoluteFile());
	}

	private static void deleteFile(String string) {
		// TODO Auto-generated method stub
		File file=new File(string);
		if(file.exists()){
			System.out.println("文件是存在的");
		}else
		{
			System.out.println("文件不存在");
		}
		if(file.delete()){
			System.out.println("文件被删除了");
		}else
		{
			System.out.println("无法删除文件");
		}
	}

	private static void createNewFile(String string) throws IOException {
		// TODO Auto-generated method stub
		File file =new File(string);
		if(file.createNewFile()){
			System.out.println("文件创建成功");
		}else
		{
			System.out.println("文件已存在");
		}
	}
}
