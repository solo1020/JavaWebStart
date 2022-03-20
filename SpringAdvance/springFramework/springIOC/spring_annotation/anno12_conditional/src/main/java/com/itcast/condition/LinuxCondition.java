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
 * @ClassName LinuxCondition
 * @description:
 * @author: isquz
 * @time: 2022/3/20
 */
public class LinuxCondition implements Condition {
    /**
     * Determine if the condition matches.
     *
     * @param context  the condition context
     * @param metadata metadata of the {@link AnnotationMetadata class}
     *                 or {@link MethodMetadata method} being checked
     * @return {@code true} if the condition matches and the component can be registered,
     * or {@code false} to veto the annotated component's registration
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        // 获取当前环境信息 当前系统是Windows 还是Linux
        Environment environment = context.getEnvironment();

        // 获取当前系统名称
        String os = environment.getProperty("os.name");
        // 判断是否包含Windows规则
        if(os.contains("Linux")){
            return true;
        }
        return false;
    }
}
