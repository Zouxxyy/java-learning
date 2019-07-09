<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2019-07-06
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Integer result = (Integer) request.getAttribute("result");
    %>

    <%=result %>
</body>
</html>
