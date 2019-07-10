<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 6/20/2019
  Time: 8:29 AM
  Email: nhatnpa2508@gmail.com 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Note List</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>Note List</h1>
<p>
    <a href="/iNotes?action=create">Create Note</a>
</p>
<table border="1px">
    <tr>
        <th>STT</th>
        <th>Tiêu đề</th>
        <th>Phân loại</th>
        <th>Edit/Delete</th>
    </tr>
    <c:forEach items='${requestScope["notes"]}' var="note">
        <tr>
            <td>${note.getId()}</td>
            <td><a href="/iNotes?action=view&id=${note.getId()}">${note.getTitle()}</a></td>
            <td>${note.getType()}</td>
            <td><a href="/iNotes?action=edit&id=${note.getId()}">Edit</a> | <a href="/iNotes?action=delete&id=${note.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
