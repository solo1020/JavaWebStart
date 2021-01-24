<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 1/25/21
  Time: 12:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>乱码过滤器</title>
</head>
<body>

<%--    post乱码--%>
<%--    <form action="/encodingServlet" method="post">--%>

<%--    get 乱码--%>
    <form action="/encodingServlet" method="get">
        <input type="text" name="username">
        <input type="submit" value="submit">
    </form>

</body>
</html>
