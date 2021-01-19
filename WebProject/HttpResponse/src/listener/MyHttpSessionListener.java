package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @ClassName MyHttpSessionListener
 * @description:
 * @author: isquz
 * @time: 2021/1/19 22:15
 */
public class MyHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("session created..."+httpSessionEvent.getSession().getId());

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("session destroyed..."+httpSessionEvent.getSession().getId());
    }
}
