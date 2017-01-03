<%--
  Created by IntelliJ IDEA.
  User: raychen
  Date: 2016/12/29
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="check" uri="/WEB-INF/my_tags/test.tld" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <check:checkLogin/>
    <jsp:useBean id="courses" type="vo.CourseListVO" scope="session"></jsp:useBean>
    <jsp:useBean id="item" class="vo.CourseUserVO" scope="page"></jsp:useBean>
    <jsp:useBean id="state" type="util.Statistic" scope="session"></jsp:useBean>

    <%if (session.getAttribute("user_id") == null) {%>
        <h1>游客访问</h1>
        <form method="post" action="/home">
            <input type="submit" value="登录" name="login">
        </form>
    <%} else {%>
        <h1>主页</h1>
        <%if (courses.getCourses().size() == 0) {%>
            <h2>你未选择课程</h2>
        <%} else {%>
            <table>
                <tbody>
                    <tr>
                        <th>课程编号</th>
                        <th>课程名</th>
                        <th>状态</th>
                        <th>得分</th>
                    </tr>
                    <% for (int i=0;i<courses.getCourses().size(); i++){
                        pageContext.setAttribute("item", courses.getCourses().get(i));
                    %>
                        <tr>
                            <td><jsp:getProperty name="item" property="course_id"></jsp:getProperty></td>
                            <td><jsp:getProperty name="item" property="course_name"></jsp:getProperty></td>
                            <td><jsp:getProperty name="item" property="state"></jsp:getProperty></td>
                            <td><jsp:getProperty name="item" property="score"></jsp:getProperty></td>
                        </tr>
                    <%}%>
                </tbody>
            </table>
        <%}%>
        <form method="post" action="/home">
            <input type="submit" value="注销" name="logout">
        </form>
    <%}%>
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
