package com.itcast.propertysource.factory;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName YamlPropertySourceFactory
 * @description:
 * @author: isquz
 * @time: 2022/3/13
 */
public class YamlPropertySourceFactory implements PropertySourceFactory {
    public PropertySource<?> createPropertySource(String s, EncodedResource encodedResource) throws IOException {
        // 创建yaml解析器
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        // 设置资源内容
        factoryBean.setResources(encodedResource.getResource());
        // 将资源解析成properties文件
        Properties properties = factoryBean.getObject();

        // 返回一个propertysource对象
        return (s != null ? new PropertiesPropertySource(s, properties) : new PropertiesPropertySource( encodedResource.getResource().getFilename(), properties));
    }
}
