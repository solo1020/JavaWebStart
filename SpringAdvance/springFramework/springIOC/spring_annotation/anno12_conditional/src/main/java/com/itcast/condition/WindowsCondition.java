package com.itcast.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;

import java.util.Map;

/**
 * @ClassName WindowsCondition
 * @description:
 * @author: isquz
 * @time: 2022/3/20
 */
public class WindowsCondition implements Condition {

    /**
     * @description: 是否注册到ioc容器的核心方法
     * @param: context
     * @param: metadata
     * @return: boolean true表示注册到ioc容器 否则不注册
     * @author: isquz
     * @date: 2022/3/20 18:32
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取ioc使用的BeanFactory对象
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 获取当前环境信息 当前系统是Windows 还是Linux
        Environment environment = context.getEnvironment();

//        if(environment instanceof StandardEnvironment){
//            StandardEnvironment standardEnvironment = (StandardEnvironment) environment;
//            Map<String, Object> map = standardEnvironment.getSystemProperties();
//            for(Map.Entry<String, Object> me : map.entrySet()){
//                System.out.println(me.getKey() + " : " + me.getValue());
//            }
//        }

        // 获取bean定义信息的注册器
        BeanDefinitionRegistry registry = context.getRegistry();
        // 获取当前系统名称
        String os = environment.getProperty("os.name");
        // 判断是否包含Windows规则
        if(os.contains("Windows")){
            return true;
        }
        return false;
    }
}
