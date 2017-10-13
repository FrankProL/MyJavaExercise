package datetime.timer.schedule;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * 每天定时几点执行
 * ScheduledExecutorService
 * @author Frank
 *http://blog.csdn.net/langzi7758521/article/details/53424195
 */
public class ExecuteAtOclock {
	/**
	 * 定时执行方法
	 * 执行runnable中的任务
	 */
	public static void executeEightAtNightPerDay() {  
		
	    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);  
	    
	    long oneDay = 24 * 60 * 60 * 1000;  
	    long initDelay  = getTimeMillis("17:22:00") - System.currentTimeMillis();  
	    initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;  
	  
	    Runnable runnable = new Runnable() {  
            public void run() {  
                // task to run goes here  
                System.out.println("Hello !!"+new Date());  
               
            }  
        }; 
	    
	    executor.scheduleAtFixedRate(  
	            runnable,  
	            initDelay,  
	            oneDay,  
	            TimeUnit.MILLISECONDS);  
	}  
	/** 
	 * 获取指定时间对应的毫秒数 
	 * @param time "HH:mm:ss" 
	 * @return 
	 */  
	private static long getTimeMillis(String time) {  
	    try {  
	        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");  
	        DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");  
	        Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);  
	        return curDate.getTime();  
	    } catch (ParseException e) {  
	        e.printStackTrace();  
	    }  
	    return 0;  
	} 
	/**
	 * main方法中调用定时任务
	 * @param args
	 */
	public static void main(String[] args) {
		ExecuteAtOclock.executeEightAtNightPerDay();
		System.out.println(new Date());
	}
}
