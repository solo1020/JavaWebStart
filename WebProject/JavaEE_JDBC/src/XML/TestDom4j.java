package XML;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName TestDom4j
 * @Description TODO
 * @Author QZ
 * @Date 2020/7/27 0:26
 * @Version 1.0
 **/
public class TestDom4j {

    @Test
    public void testReadWebXML(){

        try {
            SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read("src/XML/web02.xml");

            Element rootElement = doc.getRootElement();
            // 获取根元素的名称
            System.out.println("root element name: " + rootElement.getName());

            // 获取根元素的属性值
            System.out.println("root element attribute value: " + rootElement.attributeValue("version"));

            List<Element> childElements = rootElement.elements();

            for (Element element : childElements){
                if ("servlet".equals(element.getName())){
                    Element servletName = element.element("servlet-name");
                    Element servletClass = element.element("servlet-class");
                    System.out.println(servletName.getText());
                    System.out.println(servletClass.getText());
                }
            }


        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
