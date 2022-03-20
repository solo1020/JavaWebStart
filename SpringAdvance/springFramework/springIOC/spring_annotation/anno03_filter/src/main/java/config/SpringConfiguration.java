package config;

import com.typefilter.DistrictTypeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @ClassName SpringConfiguration
 * @description:
 * @author: isquz
 * @time: 2022/2/20 13:35
 */

@Configuration
@ComponentScan(value = "com.itcast",
        excludeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, classes = DistrictTypeFilter.class))
public class SpringConfiguration {
}
