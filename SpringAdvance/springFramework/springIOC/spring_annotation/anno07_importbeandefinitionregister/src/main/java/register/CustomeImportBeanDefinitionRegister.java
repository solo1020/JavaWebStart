package register;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AspectJTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;

/**
 * @ClassName CustomeImportBeanDefinitionRegister
 * @description: 自定义bean定义注册器
 * @author: isquz
 * @time: 2022/3/8
 */

public class CustomeImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    // 定义表达式
    private String expression;

    // 使用者自定义配置文件中的包路径
    private String customePackage;


    public CustomeImportBeanDefinitionRegister(){
        try {
            //
            Properties properties = PropertiesLoaderUtils.loadAllProperties("customeimport.properties");
            expression = properties.getProperty("custome.importselector.expression");
            customePackage = properties.getProperty("custome.importselector.package");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * @description: 实现注册bean的功能 通过扫描指定包实现
     * @param: annotationMetadata
     * @param: beanDefinitionRegistry
     * @return: void
     * @author: isquz
     * @date: 2022/3/8 22:38
     */
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        // 定义扫描包的集合
        List<String> basePackageList = null;
        // 判断是否有@ComponentScan注解
        if(annotationMetadata.hasAnnotation(ComponentScan.class.getName())){
            // 取出注解的属性
            Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(ComponentScan.class.getName());
            // 获取属性为basepackage或value的值
            basePackageList = new ArrayList<String>(Arrays.asList((String[])annotationAttributes.get("basePackages")));
        }
        // 判断是否有此注解 没有 则basepackage为null
        // 有此注解 但是没有指定basePackaghe或value 那么 @ComponentScan 中的basepackages 的size为0
        if(basePackageList == null || basePackageList.size() == 0){
            // 用于记录@Import注解所在的类的包
            String basepackage = null;
            try {
                // 取出@Import注解类所在的包
                basepackage = Class.forName(annotationMetadata.getClassName()).getPackage().getName();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            // 添加到扫描包的集合basePackageList中
            basePackageList = new ArrayList<String>();
            basePackageList.add(basepackage);
        }

        //判断用户是否配置了扫描包路径
        if(!StringUtils.isEmpty(customePackage)){
            basePackageList.add(customePackage);
        }

        // 创建类路径扫描器
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanDefinitionRegistry,false);
        // 创建类型过滤器
        TypeFilter typeFilter = new AspectJTypeFilter(expression, CustomeImportBeanDefinitionRegister.class.getClassLoader());
        // 类型过滤器添加到扫描器中
        scanner.addIncludeFilter(typeFilter);
        // 扫描指定包
        scanner.scan(basePackageList.toArray(new String[basePackageList.size()]));
        


    }
}
