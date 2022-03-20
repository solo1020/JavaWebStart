package config;

import importselector.CustomeImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @ClassName SpringConfiguration
 * @description:
 * @author: isquz
 * @time: 2022/3/4
 */

@Configuration
@ComponentScan(basePackages = {"com.itcast.service"})
@Import(CustomeImportSelector.class)
public class SpringConfiguration {

}
