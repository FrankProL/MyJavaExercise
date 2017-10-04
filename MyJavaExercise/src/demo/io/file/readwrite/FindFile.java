package demo.io.file.readwrite;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

/**
 * FileNameFilter 使用范例
 * 查找文件
 * @author Frank
 *
 */
public class FindFile {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		System.out.println("请输入要查找的目录");
		String path = scanner.nextLine();
		System.out.println("请输入要查找的后缀");
		final String suffix= scanner.nextLine();
		
		File file = new File(path);
		String[] files=file.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(suffix))
					return true;
				else
				return false;
			}
		});
		for (String s:files){
			System.out.println(s);
		}
			
	}
}
