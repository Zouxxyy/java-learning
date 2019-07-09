<%--
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
<h1>succ1</h1>
<%
    // 登陆判断
    String username = (String) session.getAttribute("username");
    if(username == null) {
        request.setAttribute("msg", "您还没有登陆!");
        request.getRequestDispatcher("/sessionTest/login.jsp").forward(request, response);
        return;
    }
%>
欢迎，<%=username %>!

</body>
</html>
