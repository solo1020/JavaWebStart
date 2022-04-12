package config;

import config.support.YmlPropertySourceFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName SpringConfiguration
 * @description:
 * @author: isquz
 * @time: 2022/3/21
 */

@Configuration
@ComponentScan("com.itcast")
@Import(JdbcConfig.class)
@PropertySource(value = "classpath:jdbc.yml", factory = YmlPropertySourceFactory.class)
public class SpringConfiguration {
}
