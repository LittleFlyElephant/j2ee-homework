<%--
  Created by IntelliJ IDEA.
  User: raychen
  Date: 2017/1/4
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/Homework5_war_exploded/css/common.css" type="text/css">
    <title>Visitor</title>
</head>
<body>
    <jsp:useBean id="state" type="util.Statistic" scope="session"></jsp:useBean>
    <h1>游客访问</h1>
    <form method="post" action="/Homework5_war_exploded/home">
        <input type="submit" value="登录" name="login">
    </form>
    <table>
        <tbody>
        <tr>
            <td>当前登录用户:</td>
            <td><jsp:getProperty name="state" property="login"></jsp:getProperty></td>
        </tr>
        <tr>
            <td>当前游客:</td>
            <td><jsp:getProperty name="state" property="visitor"></jsp:getProperty></td>
        </tr>
        </tbody>
    </table>
</body>
</html>
