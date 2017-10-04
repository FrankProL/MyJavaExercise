package setlistmap.hashmap;

import java.util.HashMap;

public class TestHashMap {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		//put添加
		map.put("zhang", "12345");
		map.put("li", "54321");
		map.put("wang", "321123");

		System.out.println(map.size());
		System.out.println(map.keySet().size());
		
		//get获取
		String mobile = (String) map.get("zhang");
		System.out.println(mobile);

		for (Object key : map.keySet()) {
			String m=(String)map.get(key);
			System.out.println(m);
		}
		
		System.out.println("********更改**************");
		//put更改
		map.put("li", "010");
		for (Object key : map.keySet()) {
			String m=(String)map.get(key);
			System.out.println(m);
		}
		
		System.out.println("********删除*************");
		//remove删除
		map.remove("wang");
		for (Object key : map.keySet()) {
			String m=(String)map.get(key);
			System.out.println(m);
		}
	}
}
