package com.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UserController
 * @description: 页面跳转
 * @author: isquz
 * @time: 2021/11/5 21:05
 */
@Controller
public class UserController {

    /**
     * @description: 直接由springmvc框架提供HttpServletRequest对象 并设置request域中的对象
     * @param: request
     * @return: java.lang.String
     * @author: isquz
     * @date: 2021/11/21 22:22
     */  
    @RequestMapping("/addServletRequestParam")
    public String addServletRequestparam(HttpServletRequest request){
        request.setAttribute("username","setServletRequestParam");
        return "springmvc.jsp";
    }

    /**
     * @description: 
     * @param: model
     * @return: java.lang.String
     * @author: isquz
     * @date: 2021/11/21 22:22
     */  
    @RequestMapping("/addModelAttribute")
    public String addModel(Model model){
        model.addAttribute("username","addModelAttribute");
        return "springmvc.jsp";
    }

    /**
     * @description: 根据传递的
     * @param: view
     * @return: org.springframework.web.servlet.ModelAndView
     * @author: isquz
     * @date: 2021/11/21 20:19
     */  
    @RequestMapping("/updateModelView")
    public ModelAndView updateModerView(ModelAndView view){
        view.addObject("username","testUpdateRequestParamUsername");
        view.setViewName("springmvc.jsp");
        return view;
    }

    @RequestMapping("/forwardModelView")
    public ModelAndView forwardResponse(){
        System.out.println("通过页面调整进行数据响应---通过ModelAndView对象返回");
        /**
         * model 模型 用来封装数据
         * view 视图 用来展示数据
         */  
        ModelAndView modelAndView = new ModelAndView();
        // 设置model数据：
        modelAndView.addObject("username","testname");
        // 设置视图
        modelAndView.setViewName("springmvc.jsp");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String sace(){
        System.out.println("user mvc controller is running");
        return "success.jsp";
    }
}
