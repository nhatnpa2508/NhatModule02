<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 7/9/2019
  Time: 5:21 PM
  Email: nhatnpa2508@gmail.com 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">

    <fieldset>
        <legend><h2 style="color:brown">IMAGE LIST</h2></legend>
        <h3><a href="/images?action=create">Create new Image</a></h3>
        <table>
            <tr>
                <th>STT</th>
                <th>Image</th>
            </tr>
            <c:forEach items='${requestScope["imageList"]}' var="image">
                <tr>
                    <td><a>${image.getId()}</a></td>
                    <td><img src="${image.getImage()}"></td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
</form>
</body>
</html>
