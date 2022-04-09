<%--
  Created by IntelliJ IDEA.
  User: tdzjpzx
  Date: 2021/10/26
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件提交</title>
    <script>
        <%
        %>
    </script>
</head>
<body>
<button name="12" onclick="function x() {
  window.alert('文杰牛逼')
}">点我</button>
<form id="upload" enctype="multipart/form-data" method="post">
    <input name="filename1" type="file"><br>
    <input name="filename2" type="file"><br>
    <input name="filename3" type="file"><br>
    <input type="submit" name="提交">
</form>
</body>
</html>