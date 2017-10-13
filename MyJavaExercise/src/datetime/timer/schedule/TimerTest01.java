package datetime.timer.schedule;

import java.util.Timer;
import java.util.TimerTask;
/**
 * 指定延迟时间执行定时任务
 * TimerTask
 * @author Frank
 *http://blog.csdn.net/chenssy/article/details/32703499
 *
 *http://blog.csdn.net/haorengoodman/article/details/23281343/
 */
public class TimerTest01 {  
    Timer timer;  
    
    public TimerTest01(int time){  
        timer = new Timer();  
        /*
         * Parameters:
		 * task task to be scheduled.
         * delay delay in milliseconds before task is to be executed.
         */
        timer.schedule(new TimerTaskTest01(), time*1000);//可以直接使用匿名内部类，new TimerTask       
//        timer.schedule(new TimerTask() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				System.out.println("匿名内部类");
//			}
//		}, time * 1000);  
    }  
      
    public static void main(String[] args) {  
        System.out.println("timer begin....");  
        new TimerTest01(3);  //延时3s执行
    }  
}  
/**
 * 继承TimerTask类，实现run方法 
 * @author Frank
 *
 */
class TimerTaskTest01 extends TimerTask{  
	@Override
    public void run() {  
        System.out.println("Time's up!!!!");  
    }  
}  
  
