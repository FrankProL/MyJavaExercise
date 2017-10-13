package demo.string;

import java.util.Scanner;
/**
 * 截取字符串
 * @author Frank
 *
 */
public class Splitspring {  
    public static void main(String[] args){  
        String str="adlfjka";
        int len=3;
        splitString(str,len);  		//自定义函数截取
        
        // 1.split()+正则表达式来进行截取
        // 将正则传入split(),分析正则非常耗时,通过这种方式截取会有很大的性能损耗
        String str1 = "abc,12,3yy98,0";
        String[] strs=str1.split(",");
        for(int i=0,len1=strs.length;i<len1;i++){
          System.out.println(strs[i].toString());
        }
        
        //2.通过subString()方法来进行字符串截取
        //
        String sb1 = "bbbdsajjds";
        sb1.substring(2);
        //
        String sb2 = "bbbdsajjds";
        sb2.substring(2, 4);
        
        //3.通过StringUtils提供的方法
        //StringUtils.substringBefore(“dskeabcee”, “e”); 
        //StringUtils.substringBeforeLast(“dskeabcee”, “e”) 
    }  
    
    public static void splitString(String str ,int len){  
        if(null == str){  
            System.out.println("The string is null");  
            return;  
        }  
        int byteNum = 0 ;  
          
        byte[] bt = str.getBytes();  
        byteNum = bt.length;  
        if(len > byteNum){  
            len = byteNum;  
        }  
        if(bt[len]<0){  
            str = new String(bt,0,--len);  
            System.out.println(str);  
        }  
        else{  
            str = new String(bt,0,len);  
            System.out.println(str);  
        }  
    }  
}  