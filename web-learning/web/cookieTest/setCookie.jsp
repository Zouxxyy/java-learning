<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2019-07-06
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie cookie1 = new Cookie("cookie1", "zxcvb");
    response.addCookie(cookie1);

    Cookie cookie2 = new Cookie("cookie2", "zxcvb");
    response.addCookie(cookie2);
%>
</body>
</html>
