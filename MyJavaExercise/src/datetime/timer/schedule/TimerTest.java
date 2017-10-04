package datetime.timer.schedule;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerTest {
	public static void executeEightAtNightPerDay() {  
	    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);  
	    long oneDay = 24 * 60 * 60 * 1000;  
	    long initDelay  = getTimeMillis("18:21:00") - System.currentTimeMillis();  
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
	
	public static void main(String[] args) {
		TimerTest.executeEightAtNightPerDay();
		System.out.println(new Date());
//		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);  
//	    long oneDay = 24 * 60 * 60 * 1000;  
//	    long initDelay  = getTimeMillis("17:42:00") - System.currentTimeMillis();  
//	    initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;  
//	  
//	    Runnable runnable = new Runnable() {  
//            public void run() {  
//                // task to run goes here  
//                System.out.println("Hello !!"+new Date());  
//               
//            }  
//        }; 
//	    
//	    
//	    executor.scheduleAtFixedRate(  
//	            runnable,  
//	            initDelay,  
//	            oneDay,  
//	            TimeUnit.MILLISECONDS);  
	}
}
