<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加图书</title>

</head>
<body>
<!-- 显示错误信息 -->
<span style="color: red">
<c:if test="${errors!=null }">
    <c:forEach items="${errors }" var="error">
        ${error.defaultMessage }<br/>
    </c:forEach>
</c:if>
</span>
<form action="<c:url value='/book/addSubmit'/>" method="post">
    修改图书信息：
    <table width="100%" border=1>
        <tr>
            <td>图书ID</td>
            <td><input type="text" name="bookid" value="${book.bookid }"/></td>
        </tr>
        <tr>
            <td>图书名称</td>
            <td><input type="text" name="name" value="${book.name }"/></td>
        </tr>
        <tr>
            <td>图书数量</td>
            <td><input type="text" name="number" value="${book.number }"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="添加"/>
            </td>
        </tr>
    </table>

</form>
</body>

</html>