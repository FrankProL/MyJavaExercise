package setlistmap.treemap;

import java.util.Comparator;
import java.util.TreeMap;
/**
 * 使用TreeMap进行键值对排序
 * 默认按升序排列
 * 指定排序器按降序排列  --使用匿名内部类
 * http://huangqiqing123.iteye.com/blog/1461163
 * @author Frank
 *
 */
public class Demo {
	public static void main(String[] args) {  
        
        //不指定排序器  --升序排列
        TreeMap<String, String> treeMap1 = new TreeMap<String, String>();  
        treeMap1.put("2", "1");  
        treeMap1.put("b", "1");  
        treeMap1.put("1", "1");  
        treeMap1.put("a", "1");  
        System.out.println("treeMap1="+treeMap1);  
  
        //指定排序器  --降序排列
        TreeMap<String, String> treeMap2 = new TreeMap<String, String>(new Comparator<String>() {
        	/* 
             * int compare(Object o1, Object o2) 返回一个基本类型的整型， 
             * 返回负数表示：o1 小于o2， 
             * 返回0 表示：o1和o2相等， 
             * 返回正数表示：o1大于o2。 
             */  
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);	//指定排序器按照降序排列
			}
		});  
        treeMap2.put("2", "1");  
        treeMap2.put("b", "1");  
        treeMap2.put("1", "1");  
        treeMap2.put("a", "1");  
        System.out.println("treeMap2="+treeMap2);  
    }  
}

/*
 * 1、TreeMap如不指定排序器，默认将按照key值进行升序排序，如果指定了排序器，则按照指定的排序器进行排序。
 * 2、具体的排序规则，开发人员可以在int compare()方法中进行指定。
 * 
 */
