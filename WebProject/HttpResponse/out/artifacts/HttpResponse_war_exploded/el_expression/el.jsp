<%@ page import="el_expression.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: isquz
  Date: 2020/9/12
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>

    <%
        pageContext.setAttribute("company", "pageContextCompany");

        //存储字符串
        request.setAttribute("company", "JavaEEWeb");

        // 存储对象
        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
        user.setPassword("123");
        session.setAttribute("user", user);

        // 存储集合
        List<User> list = new ArrayList<User>();
        User user1 = new User();
        user1.setId(2);
        user1.setName("lisi");
        user1.setPassword("123");
        list.add(user1);
        User user2 = new User();
        user2.setId(3);
        user2.setName("wangwu");
        user2.setPassword("123");
        list.add(user2);
        application.setAttribute("list", list);
    %>

    <%--jsp脚本方式取属性的值：--%>
    <%=request.getAttribute("company")%>

    <%
        User sessionUser = (User)session.getAttribute("user");
        out.write(sessionUser.getName());
    %>

    <hr/>
    <%--使用el 表达式获取域中的值--%>
    ${requestScope.company}
    ${sessionScope.user.name}
    ${applicationScope.list[1].name}

    <hr/>
    <%--使用el表达式全域查找变量, 查找顺序从小到大依次 pageCotext request session application--%>
    ${company}
    ${user.name}
    ${list[1].name}

    <%--el执行表达式运算--%>
    ${1+1}
    ${1==1?true:false}

    <%--判断某个对象是否为null,是null返回true--%>
    ${empty user}
    ${empty list}
</body>
</html>
