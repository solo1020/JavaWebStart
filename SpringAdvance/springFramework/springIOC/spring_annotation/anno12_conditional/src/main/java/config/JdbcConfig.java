package config;

import com.itcast.condition.LinuxCondition;
import com.itcast.condition.WindowsCondition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @ClassName JdbcConfig
 * @description: 数据库连接配置
 * @author: isquz
 * @time: 2022/3/19
 */

public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean("dataSource")
    @Conditional(WindowsCondition.class)
    public DataSource createWindowsDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        System.out.println("windows url: " + url);

        return dataSource;
    }

    @Bean("dataSource")
    @Conditional(LinuxCondition.class)
    public DataSource createLinuxDataSource(
            @Value("${linux.driver}") String linuxDriver,
            @Value("${linux.url}") String linuxUrl,
            @Value("${linux.username}") String linuxUsername,
            @Value("${linux.password}") String linuxPassword){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(linuxDriver);
        dataSource.setUrl(linuxUrl);
        dataSource.setUsername(linuxUsername);
        dataSource.setPassword(linuxPassword);

        System.out.println("linux url: " + linuxUrl);

        return dataSource;
    }

}
