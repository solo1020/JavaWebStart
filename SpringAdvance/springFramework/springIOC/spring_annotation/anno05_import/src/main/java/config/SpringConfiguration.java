package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @ClassName SpringConfiguration
 * @description:
 * @author: isquz
 * @time: 2022/2/27
 */

@Configuration
@Import(JdbcConfig.class)
public class SpringConfiguration {
}
