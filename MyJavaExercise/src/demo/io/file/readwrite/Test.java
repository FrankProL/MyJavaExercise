package demo.io.file.readwrite;

import java.io.File;
import java.io.IOException;

public class Test {
	public  int t=3;
	public static void main(String[] args) throws IOException {
		Test a=new Test();
		Test b=new Test();
//		Test.t=5;
		a.t=4;
//		System.out.println(Test.t);
		System.out.println(a.t);
		System.out.println(b.t);
		
		File file1=new File("filetest");
		file1.createNewFile();
		System.out.println(file1.getAbsolutePath());
		System.out.println(file1.exists());
		if(file1.exists()){
			file1.delete();
			System.out.println(file1.exists());
		}
		File mydir =new File("src/mydir");
		if (mydir.exists()){
			System.out.println("已存在");
			if(mydir.isDirectory())
				System.out.println("是个目录");
		}else{
			System.out.println("不存在");
			mydir.mkdir();
			
		}
		if (mydir.exists()){
			System.out.println("已创建");
			if(mydir.isDirectory())
				System.out.println("是个目录");
			System.out.println(mydir.getPath());
			mydir.delete();
			System.out.println(mydir.exists());
			if (!mydir.exists())
					System.out.println("已删除");
		}
	}
}
