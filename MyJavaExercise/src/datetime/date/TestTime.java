package datetime.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTime {
	public static void main(String[] args) throws InterruptedException {
		Date date = new Date();
		System.out.println(date);
		
		SimpleDateFormat df = new SimpleDateFormat("HH");
		System.out.println(df.format(date));
//		if(df.format(date)=="154") {
//			Thread.sleep(60000);
//		};
//		Date d = new Date();
//		System.out.println(d);
//		
		if(df.format(new Date(date.getTime()-15*60*60*1000)).compareTo("05")==0) {
			System.out.println(date);
			Thread.sleep(60*1000);
			System.out.println(new Date());
		}
		
	  //
	}
}
