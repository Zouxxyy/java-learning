<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2019-07-06
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>获取cooike</h1>
    <%
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for (Cookie c : cookies)
                out.print(c.getName() + " = " + c.getValue() + "<br/>");
        }
    %>
</body>
</html>
