<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 6/15/2019
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset = UTF-8">
    <title>Index</title>
  </head>
  <body>
  <h1>Trang Index</h1>
  <%
  String username = request.getParameter("username");
  Date loginTime = (Date) request.getAttribute("loginTime");
  %>
  <h3>Hi <%=username%></h3>
  <h3>Login time: <%=loginTime%></h3>
  </body>
</html>
