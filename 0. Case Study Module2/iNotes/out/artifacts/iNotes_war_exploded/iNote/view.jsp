<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 6/20/2019
  Time: 8:30 AM
  Email: nhatnpa2508@gmail.com 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Note</title>
</head>
<body>
<h1>Note Info</h1>
<p>
    <a href="/iNotes">Bach to Note list</a>
</p>
<table>

    <tr>
        <td>Title: </td>
        <td>${requestScope["note"].getTitle()}</td>
    </tr>
    <tr>
        <td>Content: </td>
        <td>${requestScope["note"].getContent()}</td>
    </tr>
    <tr>
        <td>Type: </td>
        <td>${requestScope["note"].getType()}</td>
    </tr>
</table>
</body>
</html>
