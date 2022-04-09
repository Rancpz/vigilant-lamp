<%--
  Created by IntelliJ IDEA.
  User: tdzjpzx
  Date: 2021/10/13
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新图书</title>
</head>
<body>
<%
    int id = Integer.parseInt(request.getParameter("id"));
%>
<form action="${pageContext.request.contextPath}/book/update" method="post">
    id:<input type="text" name="id" readonly="readonly" value=<%= id%>><br>
    name:<input type="text" name="name"><br>
    price:<input type="text" name="price"><br>
    <input type="submit" value="修改"><br>
</form>
</body>
</html>
