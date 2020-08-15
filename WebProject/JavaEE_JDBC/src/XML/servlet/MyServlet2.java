package XML.servlet;

import XML.MyServlet;

/**
 * @ClassName MyServlet2
 * @Description TODO
 * @Author QZ
 * @Date 2020/7/28 23:44
 * @Version 1.0
 **/
public class MyServlet2 implements MyServlet {
    @Override
    public void init() {
        System.out.println("MyServlet2 诞生了");
    }

    @Override
    public void service() {
        System.out.println("MyServlet2 开始服务");
    }

    @Override
    public void destory() {
        System.out.println("MyServlet2 销毁了");
    }
}
