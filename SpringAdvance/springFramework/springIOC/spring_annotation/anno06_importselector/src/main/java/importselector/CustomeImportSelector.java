package importselector;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AspectJTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

/**
 * @ClassName CustomeImportSelector
 * @description:
 * @author: isquz
 * @time: 2022/3/4
 */
public class CustomeImportSelector implements ImportSelector {

    // aspect表达式
    private String expression;

    // 配置文件指定包名
    private String customePackage;

    // 默认构造器用于读取配置文件 给表达式赋值
    public CustomeImportSelector(){
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties("customerimport.properties");
            expression = properties.getProperty("custome.importselector.expression");
            customePackage = properties.getProperty("custome.importselector.package");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description: 实现要导入类的字节码
     * 导入的过滤规则 TypeFilter aspect表达式
     *
     * @param: annotationMetadata
     * @return: java.lang.String[]
     * @author: isquz
     * @date: 2022/3/4 0:42
     */
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        // 定义扫描包的名称
        List<String> basePackages = null;
        // 判断@Import注解的类有没有@ComponentScan注解
        if(annotationMetadata.hasAnnotation(ComponentScan.class.getName())){
            // 取出@ComponentScan属性
            Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(ComponentScan.class.getName());
            // 取出basePackage
            basePackages = new ArrayList<>(Arrays.asList((String[])annotationAttributes.get("basePackages")));
        }
        // 判断是否有此注解 是否指定了包扫描的信息
        // 如果没有添加@ComponentScan注解 basepacakges为null 如果设置了@CompoentScan 但是不设置basePackages属性值 则默认的basePackages为空数组
        if(basePackages == null || basePackages.size() == 0){
            String basePackage = null;
            try {
                // 取出import注解所在的类的包名
                basePackage = Class.forName(annotationMetadata.getClassName()).getPackage().getName();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            // 将包名填充到basePackages
            basePackages = new ArrayList<>();
            basePackages.add(basePackage);
        }

        // 判断是否配置文件中设置了import的包名
        if(!StringUtils.isEmpty(customePackage)){
            basePackages.add(customePackage);
        }

        // 创建类路径扫描器  false 不使用默认过滤规则
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        // 创建类型过滤器 使用aspect 表达式过滤器
        TypeFilter typeFilter = new AspectJTypeFilter(expression, CustomeImportSelector.class.getClassLoader());
        // 将类型过滤器添加到扫描器中
        scanner.addIncludeFilter(typeFilter);

        // 定义要扫描类的全限定类名集合
        final Set<String> classes = new HashSet<String>();
        // 填充集合
        for(String basePackage: basePackages){
            scanner.findCandidateComponents(basePackage).forEach(beanDefinition -> classes.add(beanDefinition.getBeanClassName()));

//            scanner.findCandidateComponents(basePackage).forEach(new Consumer<BeanDefinition>() {
//                @Override
//                public void accept(BeanDefinition beanDefinition) {
//                    classes.add(beanDefinition.getBeanClassName());
//                }
//            });
        }

        // 按照方法返回值要求返还全限定类名的数组
        return classes.toArray(new String[classes.size()] );
    }
}
