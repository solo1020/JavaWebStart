<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
	<%--练习demo：角色用户页面 打开--%>
	<%
		response.sendRedirect(request.getContextPath()+"/pages/main.jsp");
	%>

	<%--<h1>Test index 测试拦截器</h1>--%>


</body>
</html>