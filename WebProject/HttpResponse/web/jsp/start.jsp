<%--
  Created by IntelliJ IDEA.
  User: isquz
  Date: 2020/8/26
  Time: 8:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="/jsp/error.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--引用其他页面--%>
    <%@include file="/includedDemo.jsp" %>

    <%
        int i = 0;
        System.out.println(i);// 输出到控制台而不是页面

//        int y = 1/0;
    %>

    <%=i%>      //输出到页面

    <%!
        String str = "hello, China!";
    %>

    <%=str%>

    <h1>adsgdf</h1>
</body>
</html>
