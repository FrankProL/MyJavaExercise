package demo.string;

import java.util.Scanner;

public class Splitspring {  
    public static void main(String[] args){  
        System.out.print("输入");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println("请输入要截取字节长度");  
        Scanner input = new Scanner(System.in);  
        int len = input.nextInt();  
        
        splitString(str,len);  
         
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