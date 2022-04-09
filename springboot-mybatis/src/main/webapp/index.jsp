<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>
<a href="${pageContext.request.contextPath}/my/findAll">展示所有</a>
<br><br><br><br>
<form action="${pageContext.request.contextPath}/my/save" method="post">
    id:<input type="text" name="id"> <br>
    name:<input type="text" name="name"><br>
    age:<input type="text" name="age"><br>
    date:<input type="text" name="bir"> <br>
    <input type="submit" value="保存"><br>
</form>
<br><br><br><br>
<form action="${pageContext.request.contextPath}/my/findOne" method="post">
    id:<input type="text" name="id"> <br>
    <input type="submit" value="查一个"><br>
</form>
<br><br><br><br>
<form action="${pageContext.request.contextPath}/my/delete" method="post">
    id:<input type="text" name="id"> <br>
    <input type="submit" value="删除"><br>
</form>
<br><br><br><br>
<form action="${pageContext.request.contextPath}/my/update" method="post">
    id:<input type="text" name="id"> <br>
    name:<input type="text" name="name"><br>
    age:<input type="text" name="age"><br>
    bir:<input type="text" name="bir"> <br>
    <input type="submit" value="更新"><br>
</form>
</body>
</html>
