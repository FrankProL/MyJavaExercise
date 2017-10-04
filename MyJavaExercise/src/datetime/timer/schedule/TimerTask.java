package datetime.timer.schedule;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class TimerTask {
	
	public static void main(String[] args) {
		System.out.println(new Date());
		
        Runnable runnable = new Runnable() {  
            public void run() {  
                // task to run goes here  
                System.out.println("Hello !!");  
                try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }  
        }; 
        System.out.println(new Date());
        
        ScheduledExecutorService service = Executors  
                .newSingleThreadScheduledExecutor();  
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间  
        service.scheduleAtFixedRate(runnable, 10, 10, TimeUnit.SECONDS);  
        
        
    }  
}
//public class TimerTask {  
//    Timer timer;  
//      
//    public TimerTask(){  
//        Date time = getTime();  
//        System.out.println("指定时间time=" + time);  
//        timer = new Timer();  
//        timer.schedule(new TimerTaskTest02(), time);  
//    }  
//      
//    public void run() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public Date getTime(){  
//        Calendar calendar = Calendar.getInstance();  
//        calendar.set(Calendar.HOUR_OF_DAY, 11);  
//        calendar.set(Calendar.MINUTE, 39);  
//        calendar.set(Calendar.SECOND, 00);  
//        Date time = calendar.getTime();  
//          
//        return time;  
//    }  
//      
//    public static void main(String[] args) {  
//        new TimerTask();  
//    }  
//}  
//  
//class TimerTaskTest02 extends TimerTask{  
//  
//    @Override  
//    public void run() {  
//        System.out.println("指定时间执行线程任务...");  
//    }  
//}  
