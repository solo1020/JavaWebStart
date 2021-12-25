springmvc入门知识点：
====
web.xml中配置全局springmvc控制器：  
通过DispatcherServlet 统一处理所有请求  
```
<servlet>
        <servlet-name>DispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath*:spring-mvc.xml</param-value>
        </init-param>
    </servlet>
    <servlet-mapping>
        <servlet-name>DispatcherServlet</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```
@Controller 注解类  
使用@RequestMapping("/save")标记方法  
在该方法返回要进行展示的页面如 index.jsp  
在springmvc.xml中配置包扫描<context:component-scan base-package="com.itcast" />  
当浏览器访问/save 资源时  
被DispatcherServlet拦截后由扫描的base-package中设置了@RequestMapping对应url路径的方法进行响应并 跳转该方法返回的资源index.jsp   

springMVC 项目入门步骤梳理：  
---
1. 添加依赖坐标  
```
<!--servlet 3.1 规范-->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>3.0.1</version>
    <scope>provided</scope>
</dependency>
<!--jsp坐标-->
<dependency>
    <groupId>javax.servlet.jsp</groupId>
    <artifactId>jsp-api</artifactId>
    <version>2.1</version>
    <scope>provided</scope>
</dependency>
<!--spring 坐标-->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.1.9.RELEASE</version>
</dependency>
<!--springmvc 坐标-->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.1.9.RELEASE</version>
</dependency>
<!--spring web 坐标-->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-web</artifactId>
    <version>5.1.9.RELEASE</version>
</dependency>
```
2. 定义业务处理器Controller 并配置成spring的bean 等同于servlet  
该bean的处理需要使用配置文件进行package扫描：  
<context:component-scan base-package="com.itcast" />   

3. web.xml中配置springMVC核心控制器 用于将请求转发到对应的业务处理器controller  
```
<servlet>
    <servlet-name>DispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath*:spring-mvc.xml</param-value>
    </init-param>
</servlet>
<servlet-mapping>
    <servlet-name>DispatcherServlet</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>
```

4. 在方法上设置具体Controller的访问路径 等同于servlet在web.xml中配置的url-pattern  
```
@RequestMapping("/save")
public String sace(){
    System.out.println("user mvc controller is running");
    return "success.jsp";
}
```

工作流程：  
服务器启动时：  
* 加载web.xml中的DispatcherServlet  
* 读取spring-mvc.xml这的配置 加载指定包下所有标记为bean的类  
* 读取bean中方法标注为@RequestMapping 的内容
* DispatcherServlet 拦截所有请求 / 
* 使用请求路径与所有加载的@RequestMapping的内容进行比对  
* 执行对应方法  
* 根据方法返回值在webapp中查找对应的页面并展示  

springMVC核心架构：  
DispatcherServlet: 前端控制器 整体流程控制中心 调用其他组件处理用户请求  
HandleMapping: 处理器映射器 负责根据@RequestMapping 为用户请求找到对应的handle处理器   
Handle: 处理器 业务处理核心类  
HandleAdapter: 处理器适配器 通过它对Handle执行  
View Resolver: 视图解析器 将处理结果生成view视图  
View: 视图 最终产出结果 如jsp html   

基本配置：  
1. Controller加载控制：  
SpringMVC处理器对应bean必须按规范开发 为了避免与spring本身的类注解混淆冲突 通过bean加载过滤器进行设定 变现层bean标注通常设定为@Controller  

业务层与数据层bean加载由spring控制  表现层bean由springMVC 控制其加载  
```
<context:component-scan base-package="com.itcast" >
    <context:include-filter
            type="annotation"
            expression="org.springframework.stereotype.Controller" />
</context:component-scan>

等同于：
@ComponentScan(
    value="com.package",
    excludeFilters = 
        @ComponentScan.Filter(
            type=FilterType.ANNOTATION,
            classes=Controller.class)
        )
)

```

2. 静态资源加载  
web.xml中配置的DispatcherServlet会拦截所有请求包括静态资源 所以类似页面中加载图片的会被拦截 需要设置核心控制器DispatherServlet放行静态资源  
```
<mvc:resources mapping="/img/**" location="/img/" />
<mvc:resources mapping="/js/**" location="/js/" />

或使用简化格式放行所有普通资源：
<mvc:default-servlet-handle />
```

3. 中文乱码处理  
```
<filter>
    <filter-name>CharacterEncodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>UTF-8</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>CharacterEncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

4. 注解替代xml配置文件驱动项目
* 基于servlet3.0规范 自定义servlet容器初始化配置类 加载SpringMVC核心配置类  
```
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

```

* 静态资源加载
编写一个配置类实现WebMvcConfigurer接口 覆盖addResourceHandles方法 在其中对具体的资源进行配置  

注意WebMvcConfigurer的实现类需要添加注解@EnableWebMvc 否则图片等静态资源仍不能加载   

除了上述方法外 在spring-mvc.xml中配置也可以实现：  
1. 配置  <mvc:default-servlet-handler />  
2. 或配置： <mvc:resources mapping="/js/**" location="/js/" />   
---

```
package com.itcast.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName SpringMVCConfiguration
 * @description:
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


    // 等同于 <mvc:resources mapping="/img/**" location="/img/" />
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("/img/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    }

    // 等同于 <mvc:default-servlet-handler />
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
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

```

springMVC组件解析：  
---
@RequestMapping:  
用于建立请求url与处理请求方法直接的对应关系  
可以用于类上注解 也可以用于方法  
用于类上 表示该类中所有请求方法的路径的父路径   
如@RequestMapping("user") 表示其他所有方法的请求url前面应该添加user/前缀 

规范建议@RequestMapping("/xxx") 应该加斜杠   
不加斜杠的话 如果该业务方法返回的页面有进行跳转或重定向之类的 会从@RequestMapping中的地址的 相对路径进行查找页面资源   
加斜杠就是从根路径下进行查找  

```
@Controller
@RequestMapping("/user")
public class UserController {

    // 实际请求地址为 http://localhost:8080/user/save
    @RequestMapping("/save")
    public String sace(){
``` 
属性：  
value: 用于指定请求url  
method: 指定请求的方法get post   
params: 指定请求参数的限制  
如 params={"accountName"} 表示请求参数必须有accountName  
params={"money!100"} 表示请求参数中money不能是100  

地址转发前缀：  
@RequestMapping 默认返回视图通过forward转发方式 也即是地址栏不会改变  
如果修改为return "redirect:success.jsp" 则会通过重定向至指定的资源  

```
@RequestMapping("/save")
    public String sace(){
        System.out.println("user mvc controller is running");
        return "success.jsp";
    }
```

视图解析器前缀后缀：  
通过定义viewResolver视图解析器 来设置InternalResourceViewResolver 的前缀后缀  
对@RequestMapping 返回的资源路径进行拼接前缀后缀  

SpringMVC数据响应：
---
响应方式：页面跳转 回写数据  
页面跳转：  
* 直接返回字符串  
* 通过ModelAndView对象返回  

回写数据：  
* 直接返回字符串    
web基础阶段 客户端访问服务器 使用response.getWriter().print("helloworld") 即可  
controller中实现： 
可以通过springmvc框架注入response对象 并调用上述方法    
也可以通过@ResponseBody注解告诉springmvc框架 方法返回的字符串并不是跳转到对应的资源页面 而是直接在http响应体中返回   


* 返回对象和集合  
通过在xml中或代码里重写extendMessageConverters配置处理器映射器  
实现在@RequestMapping方法中直接返回对象 由处理器映射器进行对象--> 转json字符串的操作  

在springmvc各个组件中 处理器映射器 处理器适配器 视图解析器 成为springmvc的三大组件 
也可以使用<mvc:annotation-driver> 自动加载RequestMappingHandlerMapping处理器映射器 和RequestMappingHandlerAdapter 处理器适配器  
用来替换在spring-xml中进行处理器映射器的配置  同时也会默认集成jackson进行对象或集合的字符串转换   

小结：  

springmvc获取请求数据：
---
1. 获取请求参数：  
* 基本类型参数  
* POJO参数   
* 数组类型参数  
* 集合类型参数  

获取基本类型参数：   
controller中业务方法参数名称与请求参数的name一致 就会自动映射该参数  
```
/**
     * @description: 获取基本类型参数 直接把request域中参数名对应一致的放在方法参数中即可
     * @ResponseBody 表明只进行数据回写不进行页面跳转
     * 当前方法中返回值为void 即表示 本方法的response body为空
     * @param:
     * @return: void
     * @author: isquz
     * @date: 2021/11/28 1:06
     */
    @RequestMapping("requestParam")
    @ResponseBody
    public void getRequestParam(String username, int age){
        System.out.println("get username: " + username);
        System.out.println("get age: " + age);
    }
```

获取pojo类型参数：  
controller中业务方法的pojo参数属性名需要与请求参数的name一致 即会自动映射匹配  
```
@RequestMapping("requestParamToPojo")
@ResponseBody
public void getRequestParamToPojoObject(MybatisUser user){
    System.out.println("user: " + user);
}
```

获取数组类型参数：  
Controller中业务方法数组参数名称 与请求参数name一致 即可自动映射匹配    
请求地址：http://localhost/requestParamArray?arr=123&arr=rewre&arr=tse  
```
@RequestMapping("requestParamArray")
@ResponseBody
public void getRequestParamArray(String[] arr){
    for(String s: arr){
        System.out.println("get param: " + s);
    }
}
```

获取集合类型参数：  
获取集合参数 需要将集合参数封装到一个pojo对象中  
```
/**
 * @ClassName ValueObject
 * @description: 用来包装
 * @author: isquz
 * @time: 2021/11/29 21:38
 */
public class ValueObject {
    private List<MybatisUser> userList;

    public List<MybatisUser> getUserList() {
        return userList;
    }

    public void setUserList(List<MybatisUser> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "ValueObject{" +
                "userList=" + userList +
                '}';
    }
}

<html>
<head>
    <title>提交对象集合类型的数据</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/requestParamCollection" method="post">
        <%--表明是第几个user对象的username 和age 属性--%>
        <%--此处的集合名称必须 要与pojo包装类中的list集合变量一致--%>
        <input type="text" name="userList[0].username"><br/>
        <input type="text" name="userList[0].address"><br/>

        <input type="text" name="userList[1].username"><br/>
        <input type="text" name="userList[1].address"><br/>

        <input type="submit" value="提交">
    </form>

</body>
</html>

// Controller
@RequestMapping("requestParamCollection")
@ResponseBody
public void getRequestParamCollection(ValueObject object){
    System.out.println(object);
    for(MybatisUser user: object.getUserList()){
        System.out.println("user inside ValueObject: " + user);
    }
}
```

之前ajax 提交请求时 可以指定contentType为json类型 在controller中业务方法的参数中使用@RequestBody 可以直接接收集合数据而无需使用pojo进行包装   

```
// Controller
@RequestMapping("ajaxReq")
@ResponseBody
public void getRequestAjaxCollection(@RequestBody List<MybatisUser>userList){
    System.out.println(userList);
}


```

参数绑定注解@RequestParam:
---
当请求参数名称与Controller业务方法参数名词不一致时 需要通过@RequestParam(value="")注解进行绑定 来实现参数的匹配   
注解内部属性：  
value: 与实际请求参数名一致  
required: 默认为true 即提交时没有此参数则报错   
defaultValue: 当实际的请求中没有参数时 则使用默认值赋值   

获取Restful风格的参数：  
Restful是一种设计风格 而不是标准 用于客户端和服务端交互的软件 基于这个风格设计的软件会更简洁 更有层次 更易于实现缓存机制  

rest风格请求是使用url+请求方式表示一次请求的目的   
get 获取资源  
post新建资源  
put更新资源  
delete 删除资源  
如：  
/user/1 GET     得到id=1 的user  
/user/1 DELETE  删除id=1 的user   
/user/1 PUT     更新id=1 的user   
/user           新增user   

可以理解为 通过地址url来传递参数而不是原始的问号后面加参数1&参数2...   

自定义类型转换器：  
---
springmvc默认已经提供了一些常用类型转换器 例如客户端提交的字符串转换成int型进行参数设置  
但是其他的比如日期就需要自定义转换器   

使用自定义类型转换器的步骤：  
1. 定义转换器Converter 实现Converter接口   
```
public class DateConverter implements Converter<String, Date> {


    @Override
    public Date convert(String s) {
        // 将日期字符串转成日期对象
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
```
2. 在配置文件中声明转换器 也可以在springmvc的配置类中实现 免配置文件功能    
```
配置文件实现：  
<bean id="dateConverter" class="org.springframework.context.support.ConversionServiceFactoryBean">
    <property name="converters" >
        <list>
            <bean class="com.itcast.converter.DateConverter" >
        </list>
    </property>
</bean>

<mvc:annotation-driven conversion-service="dateConverter" />


// 纯代码 免配置文件实现：
// class SpringMVCConfiguration implements WebMvcConfigurer
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
```
3. 在<annotation-driven> 中引用转换器   

获取servlet相关api
---
springmvc 支持使用原始的servlet API 作为控制器方法的参数进行注入：  
HttpServletRequest  
HttpServletResponse  
HttpSession   

获取请求头：  
1. @RequestHeader  
使用此注解获取请求头信息 相当于web阶段的request.getHeader(name)  
注解中的属性如下：  
value 请求头名称  
required: 是否必须携带请求头   

2. @CookieValue  
获取指定cookie的值  
属性如下：  
value:  
required:  是否必须  

文件上传：
---
文件上传客户端表单三要素：  
表单项type="file"  
表单提交方式POST   
表单enctype属性说多部分表单形式  enctype="multipart/form-data"   

因为form表单修改为了多部分表单 multipart/form-data  所以request.getParameter() 会失效   
enctype默认为application/x-www-form-urlencoded 时 form表单正文内容格式为key=value&key=value...   
enctype为multipart/form-data时 请求正文内容就变成了多部分形式  

单文件上传：  
1. 导入fileupload和io坐标    
```
<!--文件上传-->
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.3.1</version>
</dependency>
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.3</version>
</dependency>
```
2. 配置文件上传解析器 或使用免配置文件方法  
使用配置类的方法 注入CommonsMultipartResolver对象 必须使用@Bean 是否和配置类的加载生命周期有关? 可能是在springmvc框架启动时加载该配置类 同时对于@Bean注入的CommonsMultipartResolver 进行配置   

```
// 配置文件方法
<!-- 配置文件上传解析器 -->
    <!--<bean id="multipartResolver"-->
      <!--class="org.springframework.web.multipart.commons.CommonsMultipartResolver" >-->
    <!--&lt;!&ndash;单次上传文件总大小&ndash;&gt;-->
    <!--<property name="maxUploadSize" value="5242800" />-->
    <!--&lt;!&ndash;单个上传文件大小&ndash;&gt;-->
    <!--<property name="maxUploadSizePerFile" value="5242800" />-->
    <!--&lt;!&ndash;上传文件编码类型&ndash;&gt;-->
    <!--<property name="defaultEncoding" value="UTF-8" />-->
<!--</bean>-->

// 使用配置类 免配置文件进行设置
// SpringMVCConfiguration implements WebMvcConfigurer
// 这里必须使用@Bean注解
// 添加文件上传解析器
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSizePerFile(5242800);
        resolver.setMaxUploadSize(5242800);
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }


```
3. 编写文件上传代码  

多文件上传：  
可以设置file 类型的input 的name不一致 然后对应controller中多个MultipartFile入参即可  
也可以 将controller业务方法参数直接改为MultipartFile[] 数组类型 获取多个上传的文件  

```
<form action="${pageContext.request.contextPath}/uploadFiles"
      method="post" enctype="multipart/form-data">
    名称<input type="text" name="filename"><br/>
    文件1-1<input type="file" name="upload"><br/>
    文件1-2<input type="file" name="upload"><br/>
    文件1-3<input type="file" name="upload"><br/>
    <input type="submit" value="上传"><br/>
</form>

//Controller
@RequestMapping(value = "/uploadFiles")
@ResponseBody
public void uploadFiles (String filename, MultipartFile[] upload) throwsIOException {
    System.out.println("start to upload file : " + filename);
    System.out.println("get multipartFile: " + upload);
    for(MultipartFile file : upload){
        String originalFilename = file.getOriginalFilename();
        file.transferTo(new File( "D:\\J2EE\\JavaWeb\\testupload\\" + originalFilename));
    }
}

```

spring JdbcTemplate使用
---
spring框架提供的一个原始JdbcAPI 对象的封装 提供了操作关系型数据库的JdbcTemplate 和HibernateTemplate 操作nosql的RedisTemplate 操作消息队列的JmsTemplate   

JdbcTemplate步骤：  
1. 导入spring-jdbc spring-tx坐标  
```
<!--jdbc-->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.0.5.RELEASE</version>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-tx</artifactId>
    <version>5.0.5.RELEASE</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.32</version>
</dependency>
<dependency>
    <groupId>c3p0</groupId>
    <artifactId>c3p0</artifactId>
    <version>0.9.1.2</version>
</dependency>
```
2. 创建数据库和表  
3. 创建JdbcTemplate对象   
将JdbcTemplate的创建权交给spring  
将DataSource的创建权也交给spring   
在spring容器内部将数据源datasource注入到JdbcTemplate模板对象中  
```
<!--加载jdbc.properties-->
<context:property-placeholder location="classpath:jdbc.properties"/>
<!--配置数据源对象 以便将其注入JdbcTemplate对象-->
<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource" >
    <property name="driverClass" value="${jdbc.driver}"/>
    <property name="jdbcUrl" value="${jdbc.url}"/>
    <property name="user" value="${jdbc.username}"/>
    <property name="password" value="${jdbc.password}"/>
</bean>
<!--JdbcTemplate对象-->
<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate" >
    <property name="dataSource" ref="dataSource"></property>
</bean>
```

4. 执行数据库操作  
其中可以使用SpringJunit进行测试  

```
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @description: 聚合查询
     * @param:
     * @return: void
     * @author: isquz
     * @date: 2021/12/2 23:38
     */
    @Test
    public void testQueryCount(){
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println("get all account num: " + count);
    }

    @Test
    public void testQueryOne(){
        Account lucy = jdbcTemplate.queryForObject("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), "lucy");
        System.out.println(lucy);
    }

    @Test
    public void testQuery(){
        List<Account> accountList = jdbcTemplate.query("select * from account ", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }

    @Test
    public void testUpdate(){
        int row = jdbcTemplate.update("update account set money=? where name=?",
                10000, "tom");
        System.out.println("update tom money row: " + row);
    }

    @Test
    public void testDelete(){
        int row = jdbcTemplate.update("delete from account where name=?", "tom-springmvc");
        System.out.println("delete tom-springmvc row: " + row);
    }
}
```