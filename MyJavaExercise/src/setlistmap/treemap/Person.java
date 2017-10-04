package setlistmap.treemap;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
/**
 * 使用TreeMap进行键值对排序
 * 默认按照升序进行排列
 * 定义了一个实体类Person，有name和age属性
 * @author Frank
 *
 */
public class Person {
	private String name;  
    private int age;  
  
    public Person(String name, int age) {  
        this.name = name;  
        this.age = age;  
    }  
  
    public String getName() {  
        return this.name;  
    }  
  
    public int getAge() {  
        return this.age;  
    }  
    
    public static void main(String[] args) {  
        TreeMap<Long, Object> treeMap = new TreeMap<Long, Object>();  
        treeMap.put((long) 1, new Person("Json", 20));  
        treeMap.put((long) 8, new Person("Peter", 22));  
        treeMap.put((long) 9, new Person("Divid", 25));  
        treeMap.put((long) 6, new Person("Aglia", 22));  
        // Get a set of entries  
        Set<Entry<Long, Object>> set = treeMap.entrySet();  
        // Get an iterator  
        Iterator<Entry<Long, Object>> iterator = set.iterator();  
        // Display elements  
        while (iterator.hasNext()) {  
            Entry<?, ?> entry = (Entry<?, ?>) iterator.next();  
            System.out.println(((Person)entry.getValue()).getName());  
        }  
    }  
}
