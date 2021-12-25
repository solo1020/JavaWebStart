package com.itcast.controller;

import com.itcast.domain.Role;
import com.itcast.domain.User;
import com.itcast.service.RoleService;
import com.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName UserController
 * @description:
 * @author: isquz
 * @time: 2021/12/15 22:59
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * @description: 登录成功即用户名密码匹配 则将user对象存储到session 失败则再次返回登录页面
     * @param: username
     * @param: password
     * @param: session
     * @return: java.lang.String
     * @author: isquz
     * @date: 2021/12/18 17:54
     */
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        User user = userService.login(username, password);
        if(user != null){
            // 登录成功 将user存储到session
            session.setAttribute("user",user);
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }

    @RequestMapping("/delete/{userId}")
    public String delete(@PathVariable("userId") Long userId){
        userService.delete(userId);
        return "redirect:/user/list";
    }

    /**
     * @description: 保存新增用户信息 其中 可能包含多个角色信息 用Long数组接收
     * @param: user
     * @param: roleIds
     * @return: java.lang.String
     * @author: isquz
     * @date: 2021/12/16 20:56
     */
    @RequestMapping("/save")
    public String save(User user, Long[] roleIds){
        userService.save(user,roleIds);

        return "redirect:/user/list";
    }

    /**
     * @description: 添加用户 需要实时查询最新的角色类型表
     * @param:
     * @return: org.springframework.web.servlet.ModelAndView
     * @author: isquz
     * @date: 2021/12/16 20:29
     */
    @RequestMapping("/addUI")
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;

    }

    /**
     * @description: 查询用户角色列表
     * @param:
     * @return: org.springframework.web.servlet.ModelAndView
     * @author: isquz
     * @date: 2021/12/16 20:29
     */
    @RequestMapping("/list")
    public ModelAndView list(){
        List<User> userList = userService.list();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;

    }


}
