package com.itcast.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itcast.domain.MybatisUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ReturnResponseDataController
 * @description: 回写数据进行页面展示
 * @author: isquz
 * @time: 2021/11/21 22:25
 */

@Controller
public class ReturnResponseDataController {

    /**
     * @description: springMVC 自动封装返回的对象 为json字符串
     * @param:
     * @return: com.itcast.domain.MybatisUser
     * @author: isquz
     * @date: 2021/11/23 23:12
     */
    @RequestMapping("responseObject")
    @ResponseBody
    public MybatisUser responseObject(){
        MybatisUser user = new MybatisUser();
        user.setUsername("wangwu");
        user.setAddress("HangZhou");
        return user;
    }

    @RequestMapping("responseJson")
    @ResponseBody
    public String responseJson() throws JsonProcessingException {
        MybatisUser user = new MybatisUser();
        user.setUsername("lisi");
        user.setAddress("Beijing");
        // 使用json转换工具将对象转换为json格式字符串
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(user);

    }


    /**
     * @description: 返回的字符串并不是跳转到对应的资源页面
     * 而是直接回写字符串到response响应体重
     *
     * @param:
     * @return: java.lang.String
     * @author: isquz
     * @date: 2021/11/23 22:10
     */
    @RequestMapping("/responseBody")
    @ResponseBody
    public String responseBody(){
        return "hello responseBody";
    }


    @RequestMapping("/responseWriter")
    public void responseWriter(HttpServletResponse response) throws IOException {
        response.getWriter().write("response.getWriter()");
    }

}
