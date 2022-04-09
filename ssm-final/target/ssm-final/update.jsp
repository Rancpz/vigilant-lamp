<%--
  Created by IntelliJ IDEA.
  User: tdzjpzx
  Date: 2021/7/22
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/tt/update" method="post">
    id:<input type="text" name="id"> <br>
    name:<input type="text" name="name"><br>
    age:<input type="text" name="age"><br>
    bir:<input type="text" name="bir"> <br>
    <input type="submit" value="提交"><br>
</form>
</body>
</html>
