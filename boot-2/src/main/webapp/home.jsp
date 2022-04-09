<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tdzjpzx
  Date: 2021/9/27
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>展示所有用户</title>
</head>
<script>
    function update(a) {
        window.location.href = "${pageContext.request.contextPath}/update.jsp?id=" + a;
    }
</script>
<body>
<c:forEach items="${requestScope.books}" var="book">
    id:${book.id}&nbsp;&nbsp;&nbsp;name:${book.name}&nbsp;&nbsp;&nbsp;author:${book.price}
    <button name="修改" onclick="update(${book.id})">修改</button>
    <br>
</c:forEach>
<br><br><br>
<a href="${pageContext.request.contextPath}/addBook.jsp">添加图书</a>
<a href="${pageContext.request.contextPath}/first.jsp">返回</a>
</body>
</html>
