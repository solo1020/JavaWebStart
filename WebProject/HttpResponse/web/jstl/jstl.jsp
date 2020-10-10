<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="el_expression.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: isquz
  Date: 2020/9/22
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL标签</title>
</head>
<body>

    <%--test关键字代表检查引号内部的boolean表达式的真假，为真则进入，否不进入--%>
    <c:if test="${1==1}">
        xxxx
    </c:if>
    <c:if test="${1!=1}">
        yyyy
    </c:if>

    <%
        request.setAttribute("count", 10);
    %>
    <c:if test="${count == 10}">
        count == 10
    </c:if>

    <!--forEach模拟
    for(int i=0; i<5; i++){
        sout
    }
    -->
    <c:forEach begin="0" end="5" var="i"   >
        ${i}<br/>
    </c:forEach>

    <!--
    模拟增强for循环 for(Product p: productList)
    items: 相当于productList
    var: 元素
    -->
    <c:forEach items="${productList}" var="product"  >
        ${product.pname}
    </c:forEach>

    <%
        List<String> strList = new ArrayList<String>();
        strList.add("jstl_forEach_1");
        strList.add("jstl_forEach_2");
        strList.add("jstl_forEach_3");
        strList.add("jstl_forEach_4");
        request.setAttribute("strList", strList);

        List<User> userList = new ArrayList<User>();
        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
        user.setPassword("123");
        User user1 = new User();
        user1.setId(2);
        user1.setName("lisi");
        user1.setPassword("123");
        User user2 = new User();
        user2.setId(3);
        user2.setName("wangwu");
        user2.setPassword("123");
        userList.add(user1);
        userList.add(user2);
        application.setAttribute("userList", userList);

        Map<String,String> strMap = new HashMap<String, String>();
        strMap.put("name", "lucy");
        strMap.put("age", "30");
        strMap.put("addr", "xisanqi");
        strMap.put("email", "lucy@java.com");
        session.setAttribute("strMap", strMap);

    %>

    <h1>取出strList</h1>
    <c:forEach items="${strList}" var="str" >
        ${str}<br/>
    </c:forEach>

    <h1>取出userList的数据</h1>
    <c:forEach items="${userList}" var="user" >
        user-name:${user.name}-----${user.password}<br/>
    </c:forEach>

    <h1>取出map数据</h1>
    <c:forEach items="${strMap}" var="entry" >
        ${entry.key}:${entry.value}<br/>
    </c:forEach>

</body>
</html>
