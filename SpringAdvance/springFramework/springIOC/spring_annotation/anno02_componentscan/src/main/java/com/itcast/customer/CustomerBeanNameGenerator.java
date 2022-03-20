package com.itcast.customer;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.beans.Introspector;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName CustomerBeanNameGenerator
 * @description: 自定义Bean名称生成器
 * @author: isquz
 * @time: 2022/2/15 22:31
 */


public class CustomerBeanNameGenerator implements BeanNameGenerator {

    private static final String COMPONENT_ANNOTATION_CLASSNAME = "org.springframework.stereotype.Component";

    public String generateBeanName(BeanDefinition beanDefinition, BeanDefinitionRegistry beanDefinitionRegistry) {

        String beanName = null;

        // 判断当前bean的定义信息是否是已经通过注解指定了的
        if(beanDefinition instanceof AnnotatedBeanDefinition){
            // 把definition转成注解的bean定义信息
            AnnotatedBeanDefinition annotatedBeanDefinition = (AnnotatedBeanDefinition) beanDefinition;

            // 获取注解bean定义的元信息
            AnnotationMetadata metadata = annotatedBeanDefinition.getMetadata();

            // 获取定义信息中的所有注解
            Set<String> types = metadata.getAnnotationTypes();

            // 遍历types集合
            for(String type: types){
                // 得到注解的属性
                AnnotationAttributes attributes = AnnotationAttributes.fromMap(metadata.getAnnotationAttributes(type, false));

                // 判断 attributes是否为null 同时必须说@Component及其衍生注解
                if (attributes != null && isStereotypeWithNameValue(type, metadata.getMetaAnnotationTypes(type), attributes)) {

                    // 获取value属性的值
                    Object value = attributes.get("value");
                    // 是否String类型
                    if (value instanceof String) {
                        String strVal = (String) value;
                        // 是否有值
                        if (StringUtils.hasLength(strVal)) {
                            if (beanName != null && !strVal.equals(beanName)) {
                                throw new IllegalStateException("Stereotype annotations suggest inconsistent " +
                                        "component names: '" + beanName + "' versus '" + strVal + "'");
                            }
                            beanName = strVal;
                        }
                    }
                }



            }
        }

        return beanName != null ? "my" + beanName : "my" + buildDefaultBeanName(beanDefinition);
    }

    private boolean isStereotypeWithNameValue(String annotationType,
                                                Set<String> metaAnnotationTypes, @Nullable Map<String, Object> attributes) {

        boolean isStereotype = annotationType.equals(COMPONENT_ANNOTATION_CLASSNAME) ||
                metaAnnotationTypes.contains(COMPONENT_ANNOTATION_CLASSNAME) ||
                annotationType.equals("javax.annotation.ManagedBean") ||
                annotationType.equals("javax.inject.Named");

        return (isStereotype && attributes != null && attributes.containsKey("value"));
    }

    /**
     * @description: 重写的默认自定义beanName
     * @param: definition
     * @return: java.lang.String
     * @author: isquz
     * @date: 2022/2/16 0:37
     */
    private String buildDefaultBeanName(BeanDefinition definition) {
        String beanClassName = definition.getBeanClassName();
        Assert.state(beanClassName != null, "No bean class name set");
        String shortClassName = ClassUtils.getShortName(beanClassName);
        return Introspector.decapitalize(shortClassName);
    }
}
