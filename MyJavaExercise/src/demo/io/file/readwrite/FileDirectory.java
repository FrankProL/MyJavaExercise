package demo.io.file.readwrite;

import java.io.File;
import java.io.IOException;
	/**
	 * mkdir / mkdirs 创建目录和递归目录
	 * 删除目录或文件要先检查是否存在，如果目录非空要递归删除
	 * @author Frank
	 *
	 */
public class FileDirectory {
	public static void main(String[] args) throws IOException {
		File dir= new File("E:\\javaworkspace\\MyExercise\\");
		if(dir.isDirectory()){
			System.out.println("是个目录");
		}
		for(String s:dir.list()){
			System.out.println(s);
		}
		
//		File file =new File("test1");
//		if(file.createNewFile()){
//			System.out.println("文件创建成功");
//		}else
//		{
//			System.out.println("文件已存在");
//		}
		
		createSingleDir("test1");
		deleteSingleDir("test1");
		
		createMultiDir("test2/dir");
		deleteMultiDir("test2");
		
		createFileWithDir("test3/file.txt");
		deleteMultiDir("test3");
	}

	private static void createFileWithDir(String string) {
		// 同时创建文件和目录
		File file=new File(string);
		if(file.exists()){
			System.out.println("文件已存在");
			return;
		}
		File dir=file.getParentFile();
		if(!dir.exists()){
			dir.mkdirs();
		}
		try {
			file.createNewFile();
			System.out.println("文件、目录创建成功");
		} catch (Exception e) {
			System.out.println("文件、目录创建失败");
		}
	}

	private static void deleteMultiDir(String string) {
		// 调用递归函数递归删除目录
		File dir=new File(string);
		if(!dir.exists())
			return;
		if (delete(dir)){
			System.out.println("删除目录树成功");
		}else
		{
			System.out.println("删除目录树失败");
		}
	}

	private static boolean delete(File dir) {
		// 递归删除文件或目录
		boolean flag=true;
		if(dir.isDirectory()){
			for(File file:dir.listFiles())
				flag=flag&&delete(file);
		}
		return flag&&dir.delete();
	}

	private static void createMultiDir(String string) {
		// 创建递归目录
		File dir=new File(string);
		if(dir.exists()){
			System.out.println("已存在");
			return;
		}
		if (dir.mkdirs()){
			System.out.println("目录树创建成功");
		}else
		{
			System.out.println("目录树创建失败");
		}
	}

	private static void deleteSingleDir(String string) {
		// 删除单一目录
		File dir=new File(string);
		if(!dir.exists()){
			return;
		}
		if(dir.delete()){
			System.out.println("删除成功");
		}else
		{
			System.out.println("删除失败");
		}
	}

	private static void createSingleDir(String string) {
		// 创建单一目录
		File dir=new File(string);
		if (dir.exists()){
			System.out.println("已存在");
			return;
		}
		if(dir.mkdir()){
			System.out.println("目录创建成功");
		}else{
			System.out.println("目录创建失败");
		}
	}
}
