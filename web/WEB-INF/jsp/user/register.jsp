<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/24
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增用户</title>
</head>
<body>
<form method="post" action="<c:url value="/user"/>">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="userName"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="提交"/>
            </td>
        </tr>
    </table>

</form>
</body>
</html>
