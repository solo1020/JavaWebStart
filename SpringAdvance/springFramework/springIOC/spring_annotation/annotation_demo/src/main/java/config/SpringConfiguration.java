package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName SpringConfiguration
 * @description: spring 配置类 相当于applictionContext.xml
 * @author: isquz
 * @time: 2022/1/21 22:33
 */

@Configuration
@PropertySource(value = "classpath:jdbc.properties")
@Import(value = JdbcConfig.class)
public class SpringConfiguration {

}
