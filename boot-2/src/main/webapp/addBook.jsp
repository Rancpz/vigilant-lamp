<%--
  Created by IntelliJ IDEA.
  User: tdzjpzx
  Date: 2021/10/13
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加图书</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/book/addBook" method="post">
    id:<input type="text" name="id"> <br>
    name:<input type="text" name="name"><br>
    price:<input type="text" name="price"><br>
    <input type="submit" value="添加"><br>
</form>
</body>
</html>
