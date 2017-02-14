<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>图书列表</title>
</head>
<body>
<form>
    图书列表：
    <table width="100%" border=1>
        <tr>
            <td>图书ID</td>
            <td>图书名称</td>
            <td>图书数量</td>
            <td>操作</td>
            <td align="center"><a href="<c:url value='/book/addBook'/>">添加</a></td>
        </tr>
        <c:forEach items="${list }" var="book">
        <tr>
            <td>${book.bookid }</td>
            <td>${book.name }</td>
            <td>${book.number }</td>
            <td><a HREF="<c:url value='/book/editBook/${book.bookid }'/>">修改</a></td>
            <td><a HREF="<c:url value='/book/deleteBook/${book.bookid }'/>">删除</a></td>
        </tr>
        </c:forEach>
    </table>
</form>
</body>

</html>