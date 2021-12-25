package com.itcast.resolver;

import com.itcast.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MyExceptionResolver
 * @description: 自定义异常处理器
 * @author: isquz
 * @time: 2021/12/19 23:33
 */
public class MyExceptionResolver implements HandlerExceptionResolver {

    /**
     * @description:
     * @param: httpServletRequest
     * @param: httpServletResponse
     * @param: o
     * @param: Exception e 异常对象
     * @return: ModelAndView 返回值为进行跳转的错误视图信息页面
     * @author: isquz
     * @date: 2021/12/19 23:59
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();

        if(e instanceof MyException){
            modelAndView.addObject("info","自定义异常");
        }else if(e instanceof ClassCastException){
            modelAndView.addObject("info","类型转换异常");
        }else {
            System.out.println("其他错误");
            modelAndView.addObject("info","其他错误");
        }
        modelAndView.setViewName("errorview");

        return modelAndView;
    }
}
