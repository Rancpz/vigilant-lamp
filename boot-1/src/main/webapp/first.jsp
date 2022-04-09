<%--
  Created by IntelliJ IDEA.
  User: tdzjpzx
  Date: 2021/10/12
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/book/findAll">展示所有</a>
<br><br><br><br>

<form action="${pageContext.request.contextPath}/book/findone" method="post">
    id:<input type="text" name="id"> <br>
    <input type="submit" value="查一个"><br>
</form>
<br><br><br><br>
<form action="${pageContext.request.contextPath}/book/findsome" method="post">
    id:<input type="text" name="id"> <br>
    name:<input type="text" name="name"><br>
    author:<input type="text" name="author"><br>
    <input type="submit" value="多条件查询"><br>
</form>
</body>
</html>
