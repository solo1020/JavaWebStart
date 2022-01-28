package config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @ClassName JdbcConfig
 * @description: 和jdbc操作相关的配置类
 * @author: isquz
 * @time: 2022/1/21 22:35
 */
public class JdbcConfig {

    private String driver;
    private String url;
    private String username;
    private String password;

    /**
     * @description: 创建jdbcTemplate对象并存入IOC容器
     * @param:
     * @return: org.springframework.jdbc.core.JdbcTemplate
     * @author: isquz
     * @date: 2022/1/21 22:35
     */
    // @Bean 将当前方法的返回值存储到IOC容器
    @Bean
    public JdbcTemplate createJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    public DataSource createDataSource(){
        // 创建spring内置数据源对象
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // 设置数据源
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        // 返回


    }
}
