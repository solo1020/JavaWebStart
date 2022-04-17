package com.itcast.config;

import com.itcast.doamin.Role;
import com.itcast.doamin.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName MyImportBeanDefinitionRegistrar
 * @description:
 * @author: isquz
 * @time: 2022/4/17
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(User.class).getBeanDefinition();
        registry.registerBeanDefinition("user", beanDefinition);

        AbstractBeanDefinition beanDefinitionRole = BeanDefinitionBuilder.rootBeanDefinition(Role.class).getBeanDefinition();
        registry.registerBeanDefinition("role", beanDefinitionRole);

    }
}
