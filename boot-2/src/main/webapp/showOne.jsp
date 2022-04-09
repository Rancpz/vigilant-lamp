<%--
  Created by IntelliJ IDEA.
  User: tdzjpzx
  Date: 2021/10/12
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
${book}
${book.id}===${book.name}===${book.price}
<a href="${pageContext.request.contextPath}/first.jsp">返回</a>
</body>
</html>
