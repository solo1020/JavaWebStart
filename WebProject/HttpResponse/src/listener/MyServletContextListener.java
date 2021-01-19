package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName MyServletContextListener
 * @description:
 * @author: isquz
 * @time: 2021/1/19 21:44
 */
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // 被监听的对象
        ServletContext servletContext = servletContextEvent.getServletContext();
        ServletContext source = (ServletContext) servletContextEvent.getSource();
        System.out.println("context created...");

        // 开启计息任务--每天晚上12点 计算利息
        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(task,firstTime, period);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("TimerTask 银行开始计息...");
            }
        }, new Date(), 5000);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("context destroyed...");
    }
}
