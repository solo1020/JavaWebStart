package com.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName TargetController
 * @description:
 * @author: isquz
 * @time: 2021/12/17 21:44
 */

@Controller
public class TargetController {

    @RequestMapping("/target")
    public ModelAndView show(){
        System.out.println("目标资源执行");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "testITcast");
        modelAndView.setViewName("interceptor");
        return modelAndView;
    }
}
