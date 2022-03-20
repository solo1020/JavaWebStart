package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import register.CustomeImportBeanDefinitionRegister;

/**
 * @ClassName SpringConfiguration
 * @description:
 * @author: isquz
 * @time: 2022/3/8
 */

@Configuration
@ComponentScan(basePackages = "com.itcast.service")
@Import(CustomeImportBeanDefinitionRegister.class)
public class SpringConfiguration {

}
