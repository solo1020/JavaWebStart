package com.itcast.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MyInterceptor
 * @description: 拦截器demo
 * @author: isquz
 * @time: 2021/12/18 11:34
 */

public class MyInterceptor implements HandlerInterceptor {

    // 目标方法执行之前调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("before interceptor: ");

        String param = request.getParameter("param");
        if("yes".equals(param)){
            return true;
        }else {
            System.out.println("error forward: ");
            request.getRequestDispatcher("/error.jsp").forward(request,response);
            System.out.println("finish forward: ");
            return false;
        }

        // true放行
//        return true;
    }

    // 目标方法执行之后 视图返回之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post interceptor: ");
        modelAndView.addObject("name","postHandle update Object");
    }

    // 在视图返回之后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after interceptor: ");
    }
}
