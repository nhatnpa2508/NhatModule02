<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 6/22/2019
  Time: 9:33 AM
  Email: nhatnpa2508@gmail.com 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Note</title>
</head>
<body>
<h1>Delete Note</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/notes">Back to Note list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Note info</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td><a name = "id" id = "id">${requestScope["note"].getId()}</a></td>
            </tr>
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
            <tr>
                <td><input type="submit" value="Delete Note"></td>
                <td><a href="/notes">Back to Note list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
