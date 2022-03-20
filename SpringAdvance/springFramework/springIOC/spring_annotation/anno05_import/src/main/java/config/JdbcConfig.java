package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @ClassName JdbcConfig
 * @description: 数据库连接配置
 * @author: isquz
 * @time: 2022/2/27
 */

//@Configuration
//@Component
public class JdbcConfig {

    @Bean("dataSource")
    public DataSource createDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ssm");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        return dataSource;

    }

}
