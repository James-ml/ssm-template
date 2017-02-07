<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jims
  Date: 2017/2/8
  Time: 1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json交互</title>
    <script type="text/javascript" src="<c:url value='/js/jquery-3.1.1.js'/>"></script>
    <script type="text/javascript">
        //请求json，输出是json
        function requestJson() {

            $.ajax({
                type:'post',
                url:'<c:url value="/requestJson"/>',
                contentType:'application/json;charset=utf-8',
                //数据格式是json串，商品信息
                data:'{"name":"设计","number":"99"}',
                success: function (data) {//返回json结果
                    alert(data);
                }
            });
        }
        //请求key/value，输出是json
        function responseJson() {

            $.ajax({
                type: 'post',
                url: '<c:url value="/responseJson"/>',
                //请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
                //contentType:'application/json;charset=utf-8',
                //数据格式是json串，商品信息
                data: 'name=编程&number=100',
                success: function (data) {//返回json结果
                    alert(data.number);
                }
            });
        }
    </script>
</head>
<body>
<input type="button" onclick="requestJson()" value="请求json，输出是json">
<input type="button" onclick="responseJson()" value="请求key/value，输出是json">
</body>
</html>
