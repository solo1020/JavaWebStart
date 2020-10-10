<%--
  Created by IntelliJ IDEA.
  User: isquz
  Date: 2020/9/22
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<link href="${pageContext.request.contextPath}/xxx.css">--%>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/yyy.js"></script>--%>
    <title>表单提交给jsp-使用el表达式内置对象</title>

</head>
<body>
    <form action="${pageContext.request.contextPath}/el_expression/form.jsp" method="post">
        <input type="text" name="username"><br/>
        <input type="password" name="password"><br/>
        <input type="checkbox" name="hobby" value="java">java<br/>
        <input type="checkbox" name="hobby" value="python">python<br/>
        <input type="checkbox" name="hobby" value="shell">shell<br/>
        <input type="submit" name="提交"><br/>
    </form>

    <%--<img src="${pageContext.request.contextPath}/1.jpg">--%>
    <%--<img src="${pageContext.request.contextPath}/2.jpg">--%>
    <%--<img src="${pageContext.request.contextPath}/1.jpg">--%>
</body>
</html>
