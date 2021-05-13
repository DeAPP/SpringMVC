<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>

<form method="post" action="/testPOJO">
    <input type="text" name="age" value="">
    <input type="text" name="name" value="">
    <input type="text" name="userData.authName" value="">
    <input type="submit" value="提交">
</form>
</body>
</html>