<%--
  Created by IntelliJ IDEA.
  User: tdzjpzx
  Date: 2021/11/19
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<div align="center">
    <form action="${pageContext.request.contextPath}/home.jsp" method="post">
        <input type="text" name="username">
        <input type="password" name="username">
        <input type="submit" value="登录">
    </form>
</div>
</body>
</html>
