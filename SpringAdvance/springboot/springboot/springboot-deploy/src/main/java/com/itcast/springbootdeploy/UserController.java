package com.itcast.springbootdeploy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @description:
 * @author: isquz
 * @time: 2022/4/19
 */

@RequestMapping("/user")
@RestController
public class UserController {

    @RequestMapping("/findAll")
    public String findAll(){
        return "success";
    }
}
