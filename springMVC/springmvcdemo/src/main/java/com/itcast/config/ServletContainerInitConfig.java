package com.itcast.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

/**
 * @ClassName ServletContainerInitConfig
 * @description: 替换web.xml的功能
 * @author: isquz
 * @time: 2021/11/7 23:36
 */
public class ServletContainerInitConfig extends AbstractDispatcherServletInitializer {

    /**
     * @description: 注册springmvc xml配置文件的内容
     * @param:
     * @return: org.springframework.web.context.WebApplicationContext
     * @author: isquz
     * @date: 2021/11/9 23:08
     */
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringMVCConfiguration.class);
        return ctx;
    }

    /**
     * @description:  替代web.xml中的DispatherServlet mapping映射
     * @param:
     * @return: java.lang.String[]
     * @author: isquz
     * @date: 2021/11/9 21:32
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
//        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//        ctx.register(SpringMVCConfiguration.class);
//        return ctx;

        return null;
    }

    /**
     * @description:    配置中文乱码
     * @param: servletContext
     * @return: void
     * @author: isquz
     * @date: 2021/11/9 23:07
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);

        // 创建字符集过滤器对象
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        // 设置使用的字符集
        filter.setEncoding("UTF-8");
        // 添加到Servlet容器
        FilterRegistration.Dynamic registration = servletContext.addFilter("characterEncodingFilter", filter);
        // 添加映射
        registration.addMappingForUrlPatterns(
                EnumSet.of(DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.INCLUDE),
                false, "/*");

    }
}
