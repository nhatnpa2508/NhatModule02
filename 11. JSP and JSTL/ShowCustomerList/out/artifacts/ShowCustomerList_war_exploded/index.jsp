<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 6/17/2019
  Time: 7:48 PM
  Email: nhatnpa2508@gmail.com 
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>List Customers</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<form action="/customers">
    <h2>Hiển thị danh sách khách hàng</h2>
    <input type="submit" id ="submit" value="Show Customer List">

<table border="1px" class="table table-hover">
    <caption><h1>List Customers</h1></caption>
    <tr>
        <th>Name</th>
        <th>Birthday</th>
        <th>Address</th>
        <th>Image</th>
    </tr>
    <c:forEach items='${requestScope["customers"]}' var="customer">
        <tr>
            <td>${customer.getName()}</td>
            <td>${customer.getBirthday()}</td>
            <td>${customer.getAddress()}</td>
            <td><img src=${customer.getImage()} width="60px" height="40px" alt="Image"></td>
        </tr>
    </c:forEach>
</table>
</form>
</body>
</html>
