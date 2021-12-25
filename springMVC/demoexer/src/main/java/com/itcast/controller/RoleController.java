package com.itcast.controller;

import com.itcast.domain.Role;
import com.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * @ClassName RoleController
 * @description:
 * @author: isquz
 * @time: 2021/12/5 21:04
 */

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping("/save")
    public String addRole(Role role){
        roleService.save(role);
        // 重定向到角色列表
        return "redirect:/role/list";
    }

    @RequestMapping("/list")
    public ModelAndView list(){
        System.out.println("get request mapping...");
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        System.out.println("set roleList " + roleList + "to view: " + "pages/role-list.jsp");
        // 设置model模型
        modelAndView.addObject("roleList",roleList);
        // 设置view视图
        modelAndView.setViewName("role-list");

        return modelAndView;
    }
}
