package setlistmap.treemap;

import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;
/**
 * treemap自定义降序排列
 * java8中支持lambda表达式，实现更简单
 * http://blog.csdn.net/wthfeng/article/details/51934704
 * @author Frank
 *
 */
public class Demo3 {
	public static void main(String[]args){
        Map<String,String> map = new TreeMap<>(new Comparator<String>(){
            public int compare(String o1,String o2){
                return  o2.compareTo(o1); //用正负表示大小值
            }
        });
        //以上4行可用下面一行lambda表达式代替
        //Map<String,String> map1 = new TreeMap<>((o1,o2)->o2.compareTo(o1));
        map.put("zdef","rfgh");
        map.put("asrg","zfg");
        map.put("rgd","dfgh");
        map.put("cbf","gddf");
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println("key:"+entry.getKey()+",:value:"+entry.getValue());          
        }
    }
}
