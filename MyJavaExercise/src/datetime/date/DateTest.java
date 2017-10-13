package datetime.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	public static String today_mysql = ""; 
	public static String today_impala = "";
	
	public static void main(String[] args) {
		
		String a= "20161201";
		String b= "20170501";
		
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
		
		Date datea = null;
		Date dateb = null;
		try {
			datea = df.parse(a);
			dateb = df.parse(b);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(datea);
		calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)+1);
		System.out.println(calendar);
		System.out.println(calendar.getTime());
		System.out.println(df.format(calendar.getTime()));

//		Set<String> set_date = new HashSet<>();
//		for(Date d=datea ; d.getTime() < dateb.getTime();d=new Date(d.getTime()+1*24*60*60*1000)) {
//			System.out.println(df.format(d));
//		}

//		Date d=new Date();
//		System.out.println(d.getTime());
//		String s=String.valueOf(354);
//		s.length();
//		System.out.println(s.length());
//		
//		Date calendar=new Date();
//		SimpleDateFormat dateformat_impala = new SimpleDateFormat("yyyyMMdd");
//		SimpleDateFormat dateformat_mysql = new SimpleDateFormat("yyyy-MM-dd"); 
//		today_mysql = dateformat_mysql.format(calendar);
//		today_impala = dateformat_impala.format(calendar); 
//		System.out.println("today_mysql yyyy-MM-dd:  "+ today_mysql);
//		System.out.println("today_impala yyyyMMdd:  "+ today_impala);
//		System.out.println(calendar);
//		
//		System.out.println(today_impala.substring(5,7));
	
	}
  
}
