<%--
  Created by IntelliJ IDEA.
  User: 86158
  Date: 2023/12/5/0005
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:useBean id="test" class="bean.example.messagee"/>
<%--<%@page import="bean.example.messagee" %>--%>
<%--<% String name=((messagee)request.getAttribute("username")).getUsername();%>--%>


<html>
<head>
    <title>show messqge(Bean)</title>
</head>
<body>
    <table rules="all" frame="all" border="1">
        <tr>
            <th align="center">用户名</th>
            <th align="right">密码</th>
            <th align="left">性别</th>
        </tr>
        <tr>
            <td bgcolor="#ff7f50">不知道</td>
            <td>不知道</td>
            <td>不知道</td>
        </tr>
        <tr align="right">
            <td>1,在tr设置字体位置</td>
            <td>2，里面的会默认跟着tr</td>
            <td align="left">3,除非对单元格单独设置</td>
        </tr>
        <tr>


        </tr>

    </table>
<jsp:setProperty name="test" property="password" value="123456"/>
    <!--为什么在这这里没有给bean的实例成员赋值，即使在bean里赋值了，还是显示空！-->
<jsp:getProperty name="test" property="password"/>
</body>
</html>
