package datetime.timer.schedule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 字符串反转
 * @author Frank
 *
 */
public class TestString {
	public static void main(String[] args) {
		String s= "hello";
		// 借助 StringBuilder 的 reverse()方法
		StringBuilder str= new StringBuilder(s).reverse();
		System.out.println(str);
	}
}

// i love java 输出 java love i
class StringReverse {  
    public void swap(char[] arr, int begin, int end) {  
        while(begin < end) {  
            char temp = arr[begin];  
            arr[begin] = arr[end];  
            arr[end] = temp;  
            begin++;  
            end--;  
        }  
    }  
    //I love java  
    public String swapWords(String str) {  
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
      
    public static void main(String[] args) {  
        String str = "I love java";  
        System.out.println(new StringReverse().swapWords(str));  
    }  
}  

class Main {  
	  
    public static void main(String[] args) {  
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