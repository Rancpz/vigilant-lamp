<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; utf-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>展示所有用户</title>
</head>
<body>
${user}
<c:forEach items="${requestScope.users}" var="user">
    ${user.id}===${user.name}===${user.age}===${user.bir} <br>
</c:forEach>
<a href="${pageContext.request.contextPath}/index.jsp">返回</a>
</body>
</html>