package datetime.timer.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tmp {
	public static void main(String[] args) {
		System.out.println(new StringBuilder("20000318").reverse());
		String[] time = { "201701" };
		System.out.println(time[0]);
		for (int i = 1; i <= time.length; i++) {
			System.out.println(i + time[i - 1]);
		}
		String t = "201703";
		String a = t + t;
		String[] b = { t, t };
		String[] c = { t };
		System.out.println(a);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		System.out.println(c);
		
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String day=df.format(new Date(d.getTime() - 1 * 24 * 60 * 60 * 1000));
		System.out.println(day);
	}
}
