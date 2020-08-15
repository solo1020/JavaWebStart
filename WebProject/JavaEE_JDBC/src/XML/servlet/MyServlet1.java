package XML.servlet;

import XML.MyServlet;

/**
 * @ClassName MyServlet1
 * @Description TODO
 * @Author QZ
 * @Date 2020/7/28 23:24
 * @Version 1.0
 **/
public class MyServlet1 implements MyServlet {

    @Override
    public void init() {
        System.out.println("MyServlet1 诞生了");
    }

    @Override
    public void service() {
        System.out.println("MyServlet1 开始服务");
    }

    @Override
    public void destory() {
        System.out.println("MyServlet1 销毁了");
    }
}
