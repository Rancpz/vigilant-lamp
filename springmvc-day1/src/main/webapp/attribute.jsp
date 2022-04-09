<%--
  Created by IntelliJ IDEA.
  User: tdzjpzx
  Date: 2021/7/22
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>展示参数</title>
</head>
<body>
${requestScope.name}<br><br><br>
${requestScope.user.toString()}<br><br>
${requestScope.list}

</body>
</html>
