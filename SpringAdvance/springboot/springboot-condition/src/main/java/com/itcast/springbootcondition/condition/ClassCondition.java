package com.itcast.springbootcondition.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;

import java.util.Map;

/**
 * @ClassName ClassCondition
 * @description:
 * @author: isquz
 * @time: 2022/4/16
 */
public class ClassCondition implements Condition {

    /**
     * @description:
     * @param: context 上下文 用于获取环境 IOC容器 classloader等
     * @param: metadata 注解元信息 获取注解定义的属性值
     * @return: boolean
     * @author: isquz
     * @date: 2022/4/16 16:47
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        System.out.println(context.getEnvironment());

        // 获取注解属性值value
        Map<String, Object> map = metadata.getAnnotationAttributes(ConditionOnClass.class.getName());
        // 获取注解中定义的类名数组
        String[] cls = (String[]) map.get("value");
        boolean flag = false;
        try {
            for(String s: cls){
                Class<?> aClass = Class.forName(s);
            }
            flag = true;
        } catch (ClassNotFoundException e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;

        // 导入jedis坐标后创建bean
        // 判断jedis class是否存在
//        boolean flag = false;
//        try {
//            Class<?> aClass = Class.forName("redis.clients.jedis.Jedis");
//            flag = true;
//        } catch (ClassNotFoundException e) {
//            System.out.println("Jedis dependency not imported!");
//            flag = false;
//        }
//        return flag;
    }
}
