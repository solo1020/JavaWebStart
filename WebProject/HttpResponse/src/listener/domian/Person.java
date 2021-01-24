package listener.domian;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @ClassName Person
 * @description: 对象绑定/解绑 感知监听器
 * @author: isquz
 * @time: 2021/1/20 20:40
 */
public class Person implements HttpSessionBindingListener {
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
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("person: " + this.getName() + " bounding...");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("person: " + this.getName() + " unbounding...");
    }
}
