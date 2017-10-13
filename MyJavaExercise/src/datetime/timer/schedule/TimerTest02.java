package datetime.timer.schedule;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * 在指定时间执行定时任务
 * TimerTask
 * @author Frank
 *http://blog.csdn.net/chenssy/article/details/32703499
 */

public class TimerTest02 {  
    Timer timer;  
      
    public TimerTest02(){  
        Date time = getTime();  
        System.out.println("指定时间time=" + time);  
        timer = new Timer();  
        timer.schedule(new TimerTaskTest02(), time);
    }  

    //指定时间
	public Date getTime(){  
        Calendar calendar = Calendar.getInstance();  
        calendar.set(Calendar.HOUR_OF_DAY, 10);  
        calendar.set(Calendar.MINUTE, 9);  
        calendar.set(Calendar.SECOND, 00);  
        Date time = calendar.getTime();  
        return time;  
    }  
    //执行定时方法  
    public static void main(String[] args) {  
        new TimerTest02();  
    }  
}  
  
class TimerTaskTest02 extends TimerTask{  
  
    @Override  
    public void run() {  
        System.out.println("指定时间执行线程任务...");  
    }  
}  
