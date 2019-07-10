<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Create Note</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>Create new Note</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/iNotes">Bach to Note list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Note info</legend>
        <table>
            <tr>
                <td>Title:</td>
                <td><input type="text" name="title" id="title"></td>
            </tr>
            <tr>
                <td>Content:</td>
                <td><input type="text" name="content" id="content"></td>
            </tr>
            <tr>
                <td>Type:</td>
                <td><input type="text" name="type" id="type"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create Product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
