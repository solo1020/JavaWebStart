<%--
  Created by IntelliJ IDEA.
  User: isquz
  Date: 2020/9/9
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp-include1</title>
</head>
<body>

    <h1>This is inlude1 page</h1>
    <!-- 包含include2-->
    <!-- 动态包含 -->
    <jsp:include page="/jsp/include2.jsp"></jsp:include>

    <!-- 静态包含-->
    <%--<%@include file="/jsp/include2.jsp"%>--%>

</body>
</html>
