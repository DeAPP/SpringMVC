<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>

<!-- 1.0 发送GET请求(查询用户) -->
<!-- 使用链接的形式 -->
<a href="/user/1" target="_blank">查询图书(链接get)</a><br/>
<!-- 使用表单的形式 -->
<form method="get" action="/user/1">
    <input type="submit" value="查询图书(表单get)">
</form><br>
<!-- 2.0 发送POST请求(增加用户) -->
<form method="post" action="/user" target="_blank">
    <input type="text" name="age" value="">
    <input type="text" name="name" value="">
    <input type="text" name="userData.authName" value="">
    <input type="submit" value="增加用户提交">
</form>
<!-- 3.0 发送DELETE请求(删除用户) -->
<form method="post" action="/user/1" target="_blank">
    <input type="hidden" name="_method" value="delete"/>
    <input type="submit" value="删除用户提交">
</form>
<!-- 4.0 发送PUT请求(更新用户) -->
<form method="post" action="/user/1" target="_blank">
    <input type="hidden" name="_method" value="put"/>
    <input type="submit" value="更新用户提交"/>
</form>

<%----%>
<a href="/modelAndView" target="_blank">输出ModelAndView</a>
<br/>
<a href="/testMap2" target="_blank">testMap</a>
</body>
</html>