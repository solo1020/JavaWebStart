package cofig;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * @ClassName JdbcConfig
 * @description:
 * @author: isquz
 * @time: 2022/3/20
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

    /**
     * @description:  开发环境的数据源
     * @param:
     * @return: com.alibaba.druid.pool.DruidDataSource
     * @author: isquz
     * @date: 2022/3/20 20:31
     */
    @Bean("dataSource")
    @Profile("dev")
    public DruidDataSource createDevDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        // 开发环境的最大连接数：5
        dataSource.setMaxActive(5);

        return dataSource;
    }

    /**
     * @description:  测试环境的数据源
     * @param:
     * @return: com.alibaba.druid.pool.DruidDataSource
     * @author: isquz
     * @date: 2022/3/20 20:31
     */
    @Bean("dataSource")
    @Profile("test")
    public DruidDataSource createTestDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        // 测试环境的最大连接数：5
        dataSource.setMaxActive(50);

        return dataSource;
    }

    /**
     * @description:  生产环境的数据源
     * @param:
     * @return: com.alibaba.druid.pool.DruidDataSource
     * @author: isquz
     * @date: 2022/3/20 20:31
     */
    @Bean("dataSource")
    @Profile("pro")
    public DruidDataSource createProDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        // 生产环境的最大连接数：5
        dataSource.setMaxActive(150);

        return dataSource;
    }
}
