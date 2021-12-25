<%--
  Created by IntelliJ IDEA.
  User: isquz
  Date: 2021/12/2
  Time: 0:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/uploadFiles"
          method="post" enctype="multipart/form-data">
        名称<input type="text" name="filename"><br/>
        文件1-1<input type="file" name="upload"><br/>
        文件1-2<input type="file" name="upload"><br/>
        文件1-3<input type="file" name="upload"><br/>
        <input type="submit" value="上传"><br/>
    </form>

    <%--<form action="${pageContext.request.contextPath}/upload"--%>
          <%--method="post" enctype="multipart/form-data">--%>
        <%--名称<input type="text" name="filename"><br/>--%>
        <%--文件1<input type="file" name="upload"><br/>--%>
        <%--文件2<input type="file" name="upload2"><br/>--%>
        <%--<input type="submit" value="上传"><br/>--%>
    <%--</form>--%>

</body>
</html>
