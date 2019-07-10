<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 6/20/2019
  Time: 8:31 AM
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
    <a href="/iNotes">Bach to Note list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Note Info</legend>
        <table>
            <tr>
                <td>Title:</td>
                <td>${requestScope["note"].getTitle()}</td>
            </tr>
            <tr>
                <td>Content:</td>
                <td>${requestScope["note"].getContent()}</td>
            </tr>
            <tr>
                <td>Type:</td>
                <td>${requestScope["note"].getType()}</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Delete"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
