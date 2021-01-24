package listener.attribute;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * @ClassName MyServletContextAttributeListener
 * @description:
 * @author: isquz
 * @time: 2021/1/20 0:31
 */
public class MyServletContextAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("---add servletContext attribute: " + servletContextAttributeEvent.getName());
        System.out.println("add servletContext attribute: " + servletContextAttributeEvent.getValue());

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("delete servletContext attribute: " + servletContextAttributeEvent.getName());
        System.out.println("delete servletContext attribute: " + servletContextAttributeEvent.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("before replace servletContext attribute: " + servletContextAttributeEvent.getName());
        System.out.println("before replace servletContext attribute: " + servletContextAttributeEvent.getValue());
    }
}
