package XML;

import org.junit.Test;

/**
 * @ClassName TestMyServlet
 * @Description TODO
 * @Author QZ
 * @Date 2020/7/27 22:25
 * @Version 1.0
 **/
public class TestMyServlet {
    @Test
    public void testMyServlet(){
//        MyServlet myServlet1 = new MyServletImpl();
        MyServletImpl myServlet = new MyServletImpl();
        myServlet.init();
        myServlet.service();
        myServlet.destory();
    }

    @Test
    public void testMyServlet1(){

        try {
            String className = "XML.MyServletImpl";
            Class cls = Class.forName(className);
            MyServletImpl my = (MyServletImpl) cls.newInstance();
            my.init();
            my.service();
            my.destory();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
