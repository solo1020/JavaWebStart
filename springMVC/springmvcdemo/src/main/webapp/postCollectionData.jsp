<%--
  Created by IntelliJ IDEA.
  User: isquz
  Date: 2021/11/29
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
