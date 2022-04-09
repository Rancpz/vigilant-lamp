<%--
  Created by IntelliJ IDEA.
  User: tdzjpzx
  Date: 2021/7/22
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>删除</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/tt/delete" method="post">
    id:<input type="text" name="id"> <br>
    <input type="submit" value="提交"><br>
</form>
</body>
</html>
