<%@ page import="javax.sql.rowset.serial.SerialStruct" %><%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2019-07-06
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>登陆</h1>
<%
    // 取cookie
    String username = "";
    Cookie[] cookies = request.getCookies();
    if(cookies != null){
        for (Cookie c : cookies) {
            if("username".equals(c.getName())) {
                username  =c.getValue();
            }
        }
    }
%>

<%
    String message = "";
    String msg = (String) request.getAttribute("msg");
    if (msg != null) {
        message = msg;
    }
%>
<font color="red"><b><%=message %></b></font>
<form action="/servlet_learning_war_exploded/loginServlet" method="post">
    用户名:<input type="text" name="username" value="<%=username%>"><br/>
    密码:<input type="password" name="password"/><br/>
    <br/>
    <input type="submit" value="Login">
</form>
</body>
</html>
