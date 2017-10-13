package lib.isContain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 * 判断数组中是否包含特定值
 * 直接循环判断效率最高，如果有序可以使用Arrays.binarySearch()
 * 其次可以使用List，简便，不过效率会降低
 * @author kongzhong
 * http://www.importnew.com/18700.html
 *
 */
public class IsContainsValue {
	//使用List
	public static boolean useList(String[] arr,String targetValue) {
		return Arrays.asList(arr).contains(targetValue);
	}
	//使用Set
	public static boolean useSet(String[] arr,String targetValue) {
		Set<String> set = new HashSet<String>(Arrays.asList(arr));
		return set.contains(targetValue);
	}
	//使用循环判断
	public static boolean useLoop(String[] arr,String targetValue) {
		for(String str:arr) {
			if(str.equals(targetValue)) {
				return true;
			}
		}
		return false;
	}
	//use Arrays.binarySearch()
	//Arrays.binarySearch()方法只能用于有序数组！！！如果数组无序的话得到的结果就会很奇怪。
	public static boolean useArraysBinarySearch(String[] arr,String targetValue) {
		int a = Arrays.binarySearch(arr, targetValue);
		if(a > 0 ) {
			return true;
		}else {
			return false;
		}
	}
	// 测试
	public static void main(String[] args) {
	    String[] arr = new String[] {  "CD",  "BC", "EF", "DE", "AB"};
	 
	    //use list
	    long startTime = System.nanoTime();
	    for (int i = 0; i < 100000; i++) {
	        useList(arr, "A");
	    }
	    long endTime = System.nanoTime();
	    long duration = endTime - startTime;
	    System.out.println("useList:  " + duration / 1000000);
	 
	    //use set
	    startTime = System.nanoTime();
	    for (int i = 0; i < 100000; i++) {
	        useSet(arr, "A");
	    }
	    endTime = System.nanoTime();
	    duration = endTime - startTime;
	    System.out.println("useSet:  " + duration / 1000000);
	 
	    //use loop
	    startTime = System.nanoTime();
	    for (int i = 0; i < 100000; i++) {
	        useLoop(arr, "A");
	    }
	    endTime = System.nanoTime();
	    duration = endTime - startTime;
	    System.out.println("useLoop:  " + duration / 1000000);
	 
	    //use Arrays.binarySearch()
	    startTime = System.nanoTime();
	    for (int i = 0; i < 100000; i++) {
	        useArraysBinarySearch(arr, "A");
	    }
	    endTime = System.nanoTime();
	    duration = endTime - startTime;
	    System.out.println("useArrayBinary:  " + duration / 1000000);
	    
	}
}