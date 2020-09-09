<%--
  Created by IntelliJ IDEA.
  User: isquz
  Date: 2020/9/2
  Time: 7:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" buffer="none" %>
<html>
<head>
    <title>JspWriter_out对象用法</title>
</head>
<body>
    <%--buffer默认是8kb,手动设置为0kb或者none后out将直接写到response缓冲区--%>

    <%--直接在body内输出内容，相当于html--%>
    aaaaaaaaaa

    <%--在Java代码块中输出内容--%>
    <%
        out.write("bbbbb");
        response.getWriter().write("cccccc");
    %>

    <%--直接使用Java表达式打印内容，被转换成out.write()--%>
    <%="dddddd"%>
</body>
</html>
