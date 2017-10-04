package lib.deletefile;

import java.io.File;
/**
 * 删除文件夹及文件
 * 递归删除
 * file.delete只能删除文件和空文件夹
 * @author Frank
 *
 */
public class DeleteFile {
	
	private static void deleteFile(String dir){
		
		File file=new File(dir);
		//if(file.exists())
		if (file.isDirectory()) {
			File[] c = file.listFiles();
			for (int i = 0; i < c.length; i++) {
				deleteFile(c[i].getPath());
//				System.out.println(c[i].getPath());
			}
		}
		file.delete();
	}
	
//	private static void deleteFile(String dir){
//		File file=new File(dir);
//		if (file.isDirectory()) {
//			String[] c = file.list();	//得到的是文件夹下的文件名，不是路径
//			for (int i = 0; i < c.length; i++) {
//				System.out.println(c[i]);
//				deleteFile(c[i]);		//传递的参数也只是文件名不是路径，递归调用该函数时会找不到文件（当前工程路径下找不到）
//			}
//		}
//		file.delete();
//	}

	
	public static void main(String[] args) {
		String s= "F:\\mrtest\\output\\";
		deleteFile(s);
	}

}

/*
	F:\mrtest\output\.part-r-00000.crc
	F:\mrtest\output\._SUCCESS.crc
	F:\mrtest\output\part-r-00000
	F:\mrtest\output\_SUCCESS
 */

/*
 	.part-r-00000.crc
	._SUCCESS.crc
	part-r-00000
	_SUCCESS
 */


