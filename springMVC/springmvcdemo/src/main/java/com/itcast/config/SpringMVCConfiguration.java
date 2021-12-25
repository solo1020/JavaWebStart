package com.itcast.config;

import com.itcast.converter.DateConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @ClassName SpringMVCConfiguration
 * @description: 用来实现免配置文件的替换功能
 *      类注解中一定记得添加@EnableWebMvc
 *      否则配置的addResourceHandlers 静态资源过滤仍然不能生效
 *
 * 使用当前类 替代springmvc.xml配置文件的功能
 *
 * @author: isquz
 * @time: 2021/11/7 22:57
 */

@Configuration
@EnableWebMvc
@ComponentScan(
        value = "com.itcast",
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = {Controller.class}
        )
)
public class SpringMVCConfiguration implements WebMvcConfigurer {

    // 添加文件上传解析器
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSizePerFile(5242800);
        resolver.setMaxUploadSize(5242800);
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }



    /**
     * @description:  添加自定义类型转换器 等价于在配置文件中添加：
     * <!-- 声明转换器 -->
     *     <bean id="dateConverter" class="org.springframework.context.support.ConversionServiceFactoryBean">
     *         <property name="converters" >
     *             <list>
     *                 <bean class="com.itcast.converter.DateConverter" >
     *             </list>
     *         </property>
     *     </bean>
     *
     *  <!-- <mvc:annotation-driven conversion-service="dateConverter" /> -->
     *
     *
     * @param: registry
     * @return: void
     * @author: isquz
     * @date: 2021/12/1 22:29
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        System.out.println("add converters to registry: ");
        registry.addConverter(new DateConverter());
    }

    // 等同于 <mvc:resources mapping="/img/**" location="/img/" />
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/img/**").addResourceLocations("/img/");
//        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
//    }

    // 等同于 <mvc:default-servlet-handler />
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * @description: 添加处理器映射器 来实现返回对象后springmvc直接转换成json字符串
     * @param: converters
     * @return: void
     * @author: isquz
     * @date: 2021/11/23 23:49
     */
//    等同于以下：
//     <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter" > -->
//        <property name="messageConverters">  -->
//            <list>   -->
//                <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter" >   -->
//            </list>   -->
//        </property>   -->
//     </bean>   -->
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    }
}

/*
*
* <context:component-scan base-package="com.itcast" >
<context:include-filter
        type="annotation"
        expression="org.springframework.stereotype.Controller" />
</context:component-scan>

<mvc:default-servlet-handler />
<!--<mvc:resources mapping="/img/**" location="/img/" />-->
<!--<mvc:resources mapping="/js/**" location="/js/" />-->
<!--<mvc:resources mapping="/css/**" location="/css/" />-->

* */
