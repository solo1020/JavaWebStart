package config;

import com.itcast.customer.CustomerBeanNameGenerator;
import com.itcast.service.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @ClassName SpringConfiguration
 * @description:
 * @author: isquz
 * @time: 2022/2/14 21:55
 */

@Configuration
//@ComponentScan(basePackages = {"com.itcast.service.impl", "com.itcast.utils"})
//@ComponentScan(basePackages = {"com.itcast.service.impl", "com.itcast.utils"}, nameGenerator = CustomerBeanNameGenerator.class)
//@ComponentScan(basePackageClasses = {UserService.class})

@ComponentScan(
        basePackages = {"com.itcast.service.impl", "com.itcast.utils"},
        nameGenerator = CustomerBeanNameGenerator.class,
        resourcePattern = "**/*.class",
//        includeFilters = {@ComponentScan.Filter(value = Service.class)}
        excludeFilters = {@ComponentScan.Filter(value = Service.class)}
)


// 不指定路径或类class 则以当前类的路径进行扫描
//@ComponentScan
public class SpringConfiguration {
}
