<%--
  Created by IntelliJ IDEA.
  User: 86158
  Date: 2024/3/24/0024
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!--
    request.setAttribute("data","hello jsp")

    -->
    <font color="red" size="5">${data}</font><!--这个data的值来自共享域！！request.setAttribute-->
    <h1>成功通过registry拼接前后缀，在找视图解析器渲染！！</h1>
</body>
</html>
