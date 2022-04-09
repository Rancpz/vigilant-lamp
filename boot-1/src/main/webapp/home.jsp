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
<body>
<c:forEach items="${requestScope.books}" var="book">
    id:${book.id}&nbsp;&nbsp;&nbsp;name:${book.name}&nbsp;&nbsp;&nbsp;author:${book.author}<br>
</c:forEach>
<br><br><br>
<a href="${pageContext.request.contextPath}/first.jsp">返回</a>
</body>
</html>
