<%--
  Created by IntelliJ IDEA.
  User: tdzjpzx
  Date: 2021/7/25
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Json</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<script>
    $(function () {
        $("#btn").click(function () {
            $.get("${pageContext.request.contextPath}/json/test3", function (res) {
                console.log(res);
            }, "json")
        })
    })
</script>
<body>


</body>
<input type="button" value="点我展示一群人" id="btn">
</html>
