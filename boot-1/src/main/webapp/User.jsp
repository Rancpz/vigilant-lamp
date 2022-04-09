<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tdzjpzx
  Date: 2021/10/26
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${requestScope.list}" var="user">
    id:${user.id}&nbsp;&nbsp;&nbsp;name:${user.name}<br>
</c:forEach>
</body>
</html>
