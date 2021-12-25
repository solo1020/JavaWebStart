<%--
  Created by IntelliJ IDEA.
  User: isquz
  Date: 2021/11/30
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js" ></script>
    <script>
        var userList = new Array();
        userList.push({username:"zhangsan",address:"beijing"});
        userList.push({username:"lisi",address:"hangzhou"});

        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/ajaxReq",
            data:JSON.stringify(userList),
            contentType:"application/json;charset=utf-8"
        });

    </script>
</head>
<body>

</body>
</html>
