package datetime.timer.schedule;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * 设定开始延时，并每隔多点就执行一次
 * @author Frank
 *
 */
public class ScheduledExecutorTest2 {
	public static void main(String[] args) {
		System.out.println(new Date());

		Runnable runnable = new Runnable() {
			public void run() {
				// task to run goes here
				System.out.println("Hello !!" + new Date());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		System.out.println(new Date());

		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		// 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间 ，第四个为时间单位
		service.scheduleAtFixedRate(runnable, 10, 3, TimeUnit.SECONDS);
	}
}
