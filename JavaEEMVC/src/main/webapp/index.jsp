<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="/coco">点击跳转</a>
<form method="post" action="/coco">
    <input type="text" name="姓名" value="你好啊">
    <input type="submit" value="提交">
</form>
</body>
</html>