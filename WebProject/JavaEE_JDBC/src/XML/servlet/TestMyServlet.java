package XML.servlet;

import XML.MyServlet;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/**
 * @ClassName TestMyServlet
 * @Description TODO
 * @Author QZ
 * @Date 2020/7/28 23:56
 * @Version 1.0
 **/
public class TestMyServlet {
    @Test
    public void testMyServlet1(){

        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read("src/XML/servlet/web.xml");

            Element rootEle = document.getRootElement();
            Element servletEle = rootEle.element("servlet");

            String servletClass = servletEle.element("servlet-class").getText();
            System.out.println(servletClass);
            Class cls = Class.forName(servletClass);

            MyServlet1 my1 = (MyServlet1) cls.newInstance();

            my1.init();
            my1.service();
            my1.destory();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
