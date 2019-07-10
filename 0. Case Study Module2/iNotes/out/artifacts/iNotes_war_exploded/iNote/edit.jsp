<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Edit Note</title>
</head>
<body>
<h1>Edit Note</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/iNotes">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Note Info</legend>
        <table>
            <tr>
                <td>ID:</td>
                <td>${requestScope["note"].getId()}</td>
            </tr>
            <tr>
                <td>Title:</td>
                <td><input type="text" name="title" id="title" value="${requestScope["note"].getTitle()}"></td>
            </tr>
            <tr>
                <td>Content:</td>
                <td><input type="text" name="content" id="content" value="${requestScope["note"].getContent()}"></td>
            </tr>
            <tr>
                <td>Type:</td>
                <td><input type="text" name="type" id="type" value="${requestScope["note"].getType()}"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Update">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
