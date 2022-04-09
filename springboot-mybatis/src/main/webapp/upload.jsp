<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>文件</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/file/upload" method="post" enctype="multipart/form-data">
    文件上传<input type="file" name="file"><br>
    <input type="submit" value="上传">
</form>
<br><br><br><br>
</body>
</html>
