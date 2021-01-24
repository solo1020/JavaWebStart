package listener.domian;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * @ClassName Customer
 * @description:
 * @author: isquz
 * @time: 2021/1/20 21:56
 */
public class Customer implements HttpSessionActivationListener, Serializable {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("customer: " + this.getName() + " being passivated...");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("customer: " + this.getName() + " being activated...");
    }
}
