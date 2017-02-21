<%--
  Created by IntelliJ IDEA.
  User: raychen
  Date: 2016/12/29
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="check" uri="/WEB-INF/my_tags/check.tld" %>
<html>
<head>
    <link rel="stylesheet" href="/Homework5_war_exploded/css/common.css" type="text/css">
    <title>Login</title>
</head>
<BODY>
    <check:checkLogin/>
    <h1>登录</h1>
    <form method="post" action="/Homework5_war_exploded/login">
        <input type="text" name="username">
        <input type="password" name="password">
        <input type="submit" name="login" value="登录">
        <input type="submit" name="visit" value="以游客访问">
    </form>
</BODY>
</html>
