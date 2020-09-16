<%--
  Created by IntelliJ IDEA.
  User: isquz
  Date: 2020/9/17
  Time: 0:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>设置cookie以便form.jsp获取cookie</title>
</head>
<body>
    <%
        Cookie cookie = new Cookie("abc-key","rose");
        response.addCookie(cookie);
    %>
</body>
</html>
