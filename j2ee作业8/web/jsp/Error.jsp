<%--
  Created by IntelliJ IDEA.
  User: raychen
  Date: 2017/1/1
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <jsp:useBean id="res" type="util.Result" scope="session"></jsp:useBean>
    <h1><jsp:getProperty name="res" property="message"></jsp:getProperty></h1>
</body>
</html>
