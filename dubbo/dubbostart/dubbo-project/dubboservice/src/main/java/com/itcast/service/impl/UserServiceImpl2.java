package com.itcast.service.impl;

import com.itcast.pojo.User;
import com.itcast.service.UserService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @ClassName UserServiceImpl
 * @description:
 * @author: isquz
 * @time: 2022/4/23
 */

//@Service // 本质就是一个Bean 放到IOC容器中
// dubbo service 将当前类的服务(方法)对外发布
// 将访问的地址 ip 端口 路径 注册到注册中心
// timeout 当前服务： 默认1000ms超时 重试2次 总共发送3次请求
//@Service(timeout = 3000, retries = 0, version = "v2.0")
public class UserServiceImpl2 implements UserService {

    int i = 1;

    public String sayHello() {
        return "hello dubbo----from provider ---->dubbo-service:UserServiceImpl#sayHello";
    }

    public User findUserById(int id) {
        System.out.println("call new 2.0 findUserById 被调用了 " + (i++));
        // 查询user对象
        User user = new User(1, "zhangsan","123");
        System.out.println(user.toString());
//        数据库查询很慢
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user;
    }
}
