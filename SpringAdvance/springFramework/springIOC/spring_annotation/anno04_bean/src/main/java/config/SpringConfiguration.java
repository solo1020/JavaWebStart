package config;

import annotation.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @ClassName SpringConfiguration
 * @description:
 * @author: isquz
 * @time: 2022/2/22
 */

@Configuration
public class SpringConfiguration {

    // name 需要与 @Bean存入IOC容器的
    @Resource(name = "dataSource")
    private DataSource dataSource;

    /**
     * @description:  @Bean 注解 定义在方法上时 是 将方法的返回值存入IOC容器
     * @param:
     * @return: javax.sql.DataSource
     * @author: isquz
     * @date: 2022/2/22
     */
    @Bean(value = "dataSource", autowireCandidate = true)
    public DataSource createDataSource(){
        return new DriverManagerDataSource();
    }

    @MyBean//("jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(){
        System.out.println("无参数@Bean 使用@Resource的 dataSource");
        return new JdbcTemplate(dataSource);
    }

//    @Bean
//    public JdbcTemplate createJdbcTemplate(DataSource dataSource){
//        System.out.println("@Bean 默认方法名作为bean名称 方法重载冲突：");
//        return new JdbcTemplate(dataSource);
//    }


}
