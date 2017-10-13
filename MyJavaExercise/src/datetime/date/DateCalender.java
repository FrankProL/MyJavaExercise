package datetime.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * 字符串转日期 parse
 * 日期转字符串 format
 * 依赖于SimpleDateFormat实例
 * 
 * 日期大小比较，字符串可以直接比较，Date格式要转化为秒getTime后比较,或者before、after、conmpareTo方法
 * 
 * calendar.get(Calendar.MONTH)	//获得的月份加 1 才对应实际月份
 * 
 * Calendar类的静态方法getInstance()可以初始化一个日历对象，Calendar是个抽象类
 *
 */
public class DateCalender {
	public static void main(String[] args) {

		// Calendar
		Calendar calendar = Calendar.getInstance();			//默认即为当前时间
		System.out.println(calendar.getTime());
		calendar.setTime(new Date());						//可以赋值Date类型值，更改时间
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println(calendar.get(Calendar.MONTH));	//获得的月份加 1 才对应实际月份
		// 日期加减
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)+1);
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println(calendar.get(Calendar.DATE));
		// 日期加减另一种方式
		calendar.add(Calendar.MONTH, 3);
		calendar.add(Calendar.DAY_OF_MONTH, 2);
		System.out.println(calendar.getTime());
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		
		System.out.println("===============Date==================");
		
		// Date
		Date date = new Date();
		
		// Date转化为字符串，通过SimpleDateFormat实例					******
		System.out.println(df.format(date));			//20170823
		System.out.println(date);						//Wed Aug 23 09:45:57 CST 2017
		// Date日期加减,先获取毫秒数，进行加减，然后再转为Date
		System.out.println(df.format(new Date(date.getTime()-2*24*60*60*1000)));	//20170821
		
		// 字符串转日期
		try {
			date= df.parse("20170821");
			System.out.println(date);		//Mon Aug 21 00:00:00 CST 2017
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 日期转字符串
		System.out.println(df.format(date));
		
		
		System.out.println("============Gregoriancalendar====================");
		//GregorianCalendar
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.set(1, +1);
		System.out.println(df.format(gc.getTime()));		//00010823
		gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DATE));
		// GregorianCalendar 基于Date和Calendar
		// 输入时间DAte
		// 输出需要Calendar
		// 太复杂
		
		System.out.println("===================计算时间间隔=========================");
		// http://blog.csdn.net/hongweigg/article/details/59106619
		// 计算两个时间的间隔,例如计算 2016 年 1 月 1 日距离现在有多少天
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String dateString = "2016-01-01 11:11:11";
		calendar.setTime(new Date());					//设置为当前时间
		long nowDate = calendar.getTime().getTime(); 	//Date.getTime() 获得毫秒型日期
		try {
		       long specialDate = df.parse("20171012").getTime();
		       long betweenDate = (nowDate - specialDate) / (1000 * 60 * 60 * 24); //计算间隔多少天，则除以毫秒到天的转换公式
		        System.out.print(betweenDate);
		} catch (ParseException e) {
		         e.printStackTrace();
		}
		
		System.out.println("======================日期比较大小===========================");
		// 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString_01 = "2016-01-02 11:11:10";			//若格式化为2016-01-02，则可按天进行判断
		String dateString_02 = "2016-01-02 11:11:11";
		try {
		       Date date_01 = sdf.parse(dateString_01);
		       Date date_02 = sdf.parse(dateString_02);
		       System.out.println(date_01.before(date_02)); //true，当 date_01 小于 date_02 时，为 true，否则为 false
		       System.out.println(date_02.after(date_01)); //true，当 date_02 大于 date_01 时，为 true，否则为 false
		       System.out.println(date_01.compareTo(date_02)); //-1，当 date_01 小于 date_02 时，为 -1
		       System.out.println(date_02.compareTo(date_01)); //1，当 date_02 大于 date_01 时，为 1
		       System.out.println(date_02.compareTo(date_02)); //0，当两个日期相等时，为 0
		} catch (ParseException e) {
		        e.printStackTrace();
		}
	}
}
