<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>系统登陆</title>
</head>
<body>
<h3 style="font-weight: 800;color: red">登录</h3>
<form action="<c:url value='/login'/>" method="post">
    <table>
        <tr>
            <td>用户账号：</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>用户密码 ：</td>
            <td><input type="password" name="password"/></td>
        </tr>

        <tr>
            <td></td>
            <td align="right"><input type="submit" value="登陆"/></td>
        </tr>

    </table>
</form>
</body>
</html>