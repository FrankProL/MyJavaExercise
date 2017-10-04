package setlistmap.treemap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
/**
 * 对treemap的value进行排序
 * http://www.cnblogs.com/Berryxiong/p/6240514.html
 * @author Frank
 *
 */
public class Demo5 {
	public static void sortByValue() {  
        Map<String,String> map = new TreeMap<String,String>();  
        map.put("a", "dddd");  
        map.put("d", "aaaa");  
        map.put("b", "cccc");  
        map.put("c", "bbbb");  
          
        List<Entry<String, String>> list = new ArrayList<Entry<String, String>>(map.entrySet());  
          
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {  
            //升序排序  
            public int compare(Entry<String, String> o1, Entry<String, String> o2) {  
                return o1.getValue().compareTo(o2.getValue());  
            }  
        });  
          
        for (Entry<String, String> e: list) {  
            System.out.println(e.getKey()+":"+e.getValue());  
        }  
    }  
	public static void main(String[] args) {
		new Demo5().sortByValue();
	}
}
/*
 * TreeMap底层是根据红黑树的数据结构构建的，默认是根据key的自然排序来组织（比如integer的大小，String的字典排序）。
 * 所以，TreeMap只能根据key来排序，是不能根据value来排序的（否则key来排序根本就不能形成TreeMap）。
 * 今天有个需求，就是要根据treeMap中的value排序。所以网上看了一下，大致的思路是把TreeMap的EntrySet转换成list，然后使用Collections.sort排序。
 */




