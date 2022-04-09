<%--
  Created by IntelliJ IDEA.
  User: tdzjpzx
  Date: 2021/7/22
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>展示所有</title>
</head>
<body>
${list}<br>
${user}<br><br>
<a href="${pageContext.request.contextPath}/findOne.jsp">查询</a><br>
<a href="${pageContext.request.contextPath}/delete.jsp">删除</a><br>
<a href="${pageContext.request.contextPath}/saveUser.jsp">添加</a><br>
<a href="${pageContext.request.contextPath}/update.jsp">修改</a><br>
</body>
</html>
