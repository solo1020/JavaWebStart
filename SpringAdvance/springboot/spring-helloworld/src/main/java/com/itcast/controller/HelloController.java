package com.itcast.controller;

import com.itcast.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @description:
 * @author: isquz
 * @time: 2022/3/26
 */

@RestController
public class HelloController {

    @Value("${name}")
    private String name;

    @Value("${person.name}")
    private String name2;

    @Value("${person.age}")
    private int age;

//    @Value("${person.address}")
    private String address;

    @Value("${address[0]}")
    private String address1;

    @Autowired
    private Environment env;

    @Autowired
    private Person person;

    @RequestMapping("/hello2")
    public String hello2(){
        System.out.println(name);
        System.out.println(name2);
        System.out.println(age);
//        System.out.println(address);
        System.out.println(address1);
        System.out.println("-----------------------");

        System.out.println("env: " + env);
        System.out.println(env.getProperty("person.age"));
        System.out.println(env.getProperty("address[0]"));

        System.out.println("-----------------------");
        System.out.println(person);

        String[] addressList = person.getAddress();
        for(String s: addressList){
            System.out.println(s);
        }
        return "hello SpringBoot 222";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello SpringBoot";
    }
}
