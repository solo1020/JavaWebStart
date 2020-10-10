<%--
  Created by IntelliJ IDEA.
  User: isquz
  Date: 2020/9/17
  Time: 0:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取form提交的表单</title>
</head>
<body>

    <%--获取表单参数--%>
    <%
        request.getParameter("username");
        //....使用servlet中代码实现
    %>

    <%--使用el获取--%>
    ${param.username}<br/>

    <%--部分参数需要使用[]中括号语法取值--%>
    ${header["User-Agent"]}<br/>
    ${header.Host}<br/>

    <%--获取全局初始化参数--%>
    ${initParam.driver}<br/>

    ${cookie["abc-key"].value}<br/>

    <%--通过el获取request--%>
    ${pageContext.request}<br/>

    <%--通过el获取web应用的路径contextPath--%>
    ${pageContext.request.contextPath}<br/>

</body>
</html>
