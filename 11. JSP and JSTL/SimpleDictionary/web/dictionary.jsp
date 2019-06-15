<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="static java.lang.System.out" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 6/15/2019
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<%! Map<String, String> dictionary = new HashMap<>();%>
<%
    dictionary.put("hello","Xin chao");
    dictionary.put("how","The nao");
    dictionary.put("so what?","Lam sao");
    dictionary.put("computer","May tinh");
    String search = request.getParameter("input");
    String result = dictionary.get(search);
    PrintWriter writer = response.getWriter();
        if(result !=null){
            writer.println("<html>");
            writer.println("<p>Word: " + search + "</p>");
            writer.println("<p>Result: " + result+ "</p>");
            writer.println("</html>");
        } else {
            out.println("Not found");
        }
%>
</body>
</html>
