package config.support;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName YmlPropertySourceFactory
 * @description:
 * @author: isquz
 * @time: 2022/3/21
 */
public class YmlPropertySourceFactory implements PropertySourceFactory {

    public PropertySource<?> createPropertySource(String s, EncodedResource encodedResource) throws IOException {
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(encodedResource.getResource());
        Properties properties = factoryBean.getObject();

        return s != null ? new PropertiesPropertySource(s, properties)
                : new PropertiesPropertySource(encodedResource.getResource().getFilename(), properties);
    }
}
