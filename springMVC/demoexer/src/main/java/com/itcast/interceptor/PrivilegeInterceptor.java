package com.itcast.interceptor;

import com.itcast.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName PrivilegeInterceptor
 * @description: 登录拦截器
 * @author: isquz
 * @time: 2021/12/18 17:31
 */

public class PrivilegeInterceptor implements HandlerInterceptor {


    /**
     * @description: 判断用户是否登录 实质是判断session中是否存在user对象
     * @param: request
     * @param: response
     * @param: handler
     * @return: boolean
     * @author: isquz
     * @date: 2021/12/18 17:37
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null){
            // 没有登录 进行跳转到登录页面
            System.out.println("用户未登录");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return false;
        }
        System.out.println("用户已登录");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
