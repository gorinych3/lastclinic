<%--
  Created by IntelliJ IDEA.
  User: Егор
  Date: 15.08.2018
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/user/create" method="post">
    <table>
        <tr>
            <td align="right">Login : </td>
            <td>
                <input type="text" name="login">
            </td>
        </tr>
        <tr>
            <td align="right">Email : </td>
            <td>
                <input type="text" name="email">
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" name="Submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>
