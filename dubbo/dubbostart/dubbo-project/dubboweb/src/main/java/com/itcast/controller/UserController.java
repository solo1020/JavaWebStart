package com.itcast.controller;

import com.itcast.pojo.User;
import com.itcast.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @description:
 *
 * 远程注入功能：
 * @Reference
 *
 * 从zookeeper注册中心获取userService的访问url
 * 进行远程调用rpc
 * 将结果封装为一个代理对象 给变量赋值
 *
 * @author: isquz
 * @time: 2022/4/28
 */

@RestController
@RequestMapping("/user")
public class UserController {

//    @Autowired
//    @Reference(timeout = 1000, version = "v1.0", loadbalance = "random")  //远程注入
//    @Reference(cluster = "failover", version = "v1.0")
    // mock force:return null 表示不去调用userService 的服务
    @Reference(cluster = "failover", version = "v1.0", mock = "fail:return null")
    private UserService userService;

    @RequestMapping("/sayHello")
    public String sayHello(){
        return userService.sayHello();
    }

    int i = 1;

    @RequestMapping("/find")
    public User find(int id){

        new Thread(new Runnable() {
            public void run() {
                int count = 10;
                while (true){
                    System.out.println("Thread:"+Thread.currentThread() + " " + i++);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(count-- <= 0){
                        break;
                    }
                }
            }
        }).start();
        return userService.findUserById(id);
    }
}
