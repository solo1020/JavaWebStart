package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName SpringConfiguration
 * @description:
 * @author: isquz
 * @time: 2022/3/19
 */

@Configuration
@Import(JdbcConfig.class)
@PropertySource({"classpath:jdbc.properties", "classpath:linuxjdbc.properties"})
public class SpringConfiguration {
}
