<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 6/22/2019
  Time: 9:34 AM
  Email: nhatnpa2508@gmail.com 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Note</title>
</head>
<body>
<h1>Note</h1>
<p>
    <a href="/notes">Back to Note list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Note info</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td>${requestScope["note"].getId()}</td>
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
                <td><a href="/notes">Back to Note list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
