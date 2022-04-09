<%--
  Created by IntelliJ IDEA.
  User: tdzjpzx
  Date: 2021/7/22
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <form action="${pageContext.request.contextPath}/tt/save" method="post">
        id:<input type="text" name="id"> <br>
        name:<input type="text" name="name"><br>
        age:<input type="text" name="age"><br>
        date:<input type="text" name="bir"> <br>
        <input type="submit" value="提交"><br>
    </form>
</center>
</body>
</html>
