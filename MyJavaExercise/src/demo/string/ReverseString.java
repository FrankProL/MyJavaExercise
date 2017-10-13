package demo.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 字符串反转
 * @author Frank
 *
 */
public class ReverseString {
	public static void main(String[] args) {
		String s= "hello";
		// 借助 StringBuilder 的 reverse()方法
		StringBuilder str= new StringBuilder(s).reverse();
		System.out.println(str);
		
		
		String str1 = "I love java";  
        System.out.println(swapWords(str1));
        
        SelfDefReverse();
	}
	
	/**
	 * i love java 输出 java love i
	 */
	public static void swap(char[] arr, int begin, int end) {  
        while(begin < end) {  
            char temp = arr[begin];  
            arr[begin] = arr[end];  
            arr[end] = temp;  
            begin++;  
            end--;  
        }  
    }  
    //I love java  
    public static String swapWords(String str) {  
        char[] arr = str.toCharArray();  
        swap(arr, 0, arr.length - 1);  
        int begin = 0;  
        for (int i = 1; i < arr.length; i++) {  
            if (arr[i] == ' ') {  
                swap(arr, begin, i - 1);  
                begin = i + 1;  
            }  
        }  
        return new String(arr);  
    }  
	
    /**
     * 自定义借助Collections.reverse(list)方法实现字符串反转
     */
    public static void SelfDefReverse() {  
        String str = "i love java";  
          
        String[] sArr = str.split(" ");//I love java  
          
        List<String> list = new ArrayList<String>();  
          
        list = Arrays.asList(sArr);  
          
//      for(int i=0;i<sArr.length;i++){  
//          list.add(sArr[i]);  
//      }  
        // 借助Collections.reverse(list)方法
        Collections.reverse(list);  
          
        for(String word:list){  
            System.out.print(word+" ");  
        }  
    } 
}
