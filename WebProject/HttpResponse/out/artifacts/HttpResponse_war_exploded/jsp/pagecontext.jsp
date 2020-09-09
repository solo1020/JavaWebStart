<%--
  Created by IntelliJ IDEA.
  User: isquz
  Date: 2020/9/2
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext往request域存数据</title>
</head>
<body>

    <%
//        使用pageContext向request域存数据
        request.setAttribute("name","zhangsan");
        pageContext.setAttribute("name","sunba");       // pageContext域
//        参数设置作用范围为 request域
        pageContext.setAttribute("name","lisi", PageContext.REQUEST_SCOPE);
//        参数作用范围为session域
        pageContext.setAttribute("name","wangwu", PageContext.SESSION_SCOPE);
//        参数作用范围为 application域 整个应用域范围
        pageContext.setAttribute("name","tianqi", PageContext.APPLICATION_SCOPE);
    %>

    <%=request.getAttribute("name")%>
    <%=pageContext.getAttribute("name",PageContext.REQUEST_SCOPE)%>

    <%--findAttribute 从域的范围从小到大依次查找该属性--%>
    <%--pageContext域 < request域 < session域 < application域--%>
    <%=pageContext.findAttribute("name")%>

    <%
        pageContext.getRequest();
        pageContext.getSession();
    %>
</body>
</html>
