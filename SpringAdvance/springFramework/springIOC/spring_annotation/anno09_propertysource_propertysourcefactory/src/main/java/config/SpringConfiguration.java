package config;

import com.itcast.propertysource.factory.YamlPropertySourceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName SpringConfiguration
 * @description:
 * @author: isquz
 * @time: 2022/3/13
 */

@Configuration
@PropertySource(value = "classpath:jdbc.yml", factory = YamlPropertySourceFactory.class)
@Import(JdbcConfig.class)
public class SpringConfiguration {
}
