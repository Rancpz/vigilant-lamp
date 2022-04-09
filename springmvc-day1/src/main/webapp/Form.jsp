<%--
  Created by IntelliJ IDEA.
  User: tdzjpzx
  Date: 2021/7/21
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/test3" method="post">
    id <input type="text" name="id"> <br>
    name <input type="text" name="name"><br>
    date <input type="text" name="date"> <br>
    <input type="submit" value="提交"><br>
</form>
</body>
</html>
