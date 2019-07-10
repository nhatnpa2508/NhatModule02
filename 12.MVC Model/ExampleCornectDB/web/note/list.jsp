<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 6/20/2019
  Time: 1:51 PM
  Email: nhatnpa2508@gmail.com 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Note</title>
    <style>
        table {
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<h1>Notes</h1>
<p>
    <a href="/notes?action=create">Create new Notes</a>
</p>
<form method="post">
    <table border="1px">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Type</th>
            <th>Edit / Delete</th>
        </tr>
        <c:forEach items='${requestScope["notes"]}' var="note">
            <tr>
                <td><a>${note.getId()}</a></td>
                <td><a href="/notes?action=view&id=${note.getId()}">${note.getTitle()}</a></td>
                <td>${note.getType()}</td>
                <td><a href="/notes?action=edit&id=${note.getId()}">Edit</a>|<a
                        href="/notes?action=delete&id=${note.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
