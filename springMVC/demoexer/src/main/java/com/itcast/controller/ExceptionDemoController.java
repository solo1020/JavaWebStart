package com.itcast.controller;

import com.itcast.exception.MyException;
import com.itcast.service.ExceptionDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName ExceptionDemoController
 * @description: 异常处理demo
 * @author: isquz
 * @time: 2021/12/19 0:02
 */

@Controller
public class ExceptionDemoController {

    @Autowired
    public ExceptionDemoService exceptionDemoService;

    @RequestMapping(value = "/show")
    public String show(@RequestParam(value = "name", required = false) String name ) throws MyException {
        System.out.println("show running...");
//        exceptionDemoService.classCastException();
        exceptionDemoService.myException();
        return "index";
    }
}
