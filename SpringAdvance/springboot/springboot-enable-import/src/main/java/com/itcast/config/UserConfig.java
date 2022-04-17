package com.itcast.config;

import com.itcast.doamin.Role;
import com.itcast.doamin.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName UserConfig
 * @description:
 * @author: isquz
 * @time: 2022/4/16
 */

@Configuration
public class UserConfig {

    @Bean
    public User user(){
        return new User();
    }

    @Bean
    public Role role(){
        return new Role();
    }
}
