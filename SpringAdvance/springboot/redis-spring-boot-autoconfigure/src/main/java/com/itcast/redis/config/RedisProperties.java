package com.itcast.redis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName RedisProperties
 * @description: redis配置文件
 * @author: isquz
 * @time: 2022/4/17
 */

@ConfigurationProperties(prefix = "myredis")
public class RedisProperties {

    private String host = "localhost";
    private int port = 6379;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
