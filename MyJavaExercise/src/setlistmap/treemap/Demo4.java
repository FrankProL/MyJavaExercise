package setlistmap.treemap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * 通过Collections中的sort方法对treemap中的值进行排序
 * @author Frank
 *
 */
public class Demo4 {
	public static void main(String[] args) {
		Map<Integer, String> map = new TreeMap<Integer, String>();
	     map.put(20, "ggg");
	     map.put(13, "qqq");
	     map.put(40, "abc");
	     map.put(12, "yyy");
	     List<Map.Entry<Integer, String>> list = new ArrayList<Map.Entry<Integer, String>>();
	     for (Map.Entry<Integer, String> entry : map.entrySet()) {
	         list.add(entry);
	     }
	     java.util.Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
	         //对值进行比较
	         @Override
	         public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
	             return o1.getValue().compareTo(o2.getValue());
	         }
	     });
	     //list中已经是排好序的内容
	     Map<Integer, String> rsMap = new LinkedHashMap<Integer, String>();
	     for (Map.Entry<Integer, String> entry : list) {
	         rsMap.put(entry.getKey(), entry.getValue());
	     }
	     System.out.println(list);
	}
}
