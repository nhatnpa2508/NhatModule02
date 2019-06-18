<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 6/17/2019
  Time: 10:01 PM
  Email: nhatnpa2508@gmail.com 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>Product information</h1>
<p>
    <a href="/products">Bach to product list</a>
</p>
<table>
    <tr>
        <td>ID: </td>
        <td>${requestScope["product"].getId()}</td>
    </tr>
    <tr>
        <td>Name: </td>
        <td>${requestScope["product"].getName()}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${requestScope["product"].getPrice()}</td>
    </tr>
    <tr>
        <td>Information: </td>
        <td>${requestScope["product"].getInfo()}</td>
    </tr>
    <tr>
        <td>Producer</td>
        <td>${requestScope["product"].getProducer()}</td>
    </tr>
</table>
</body>
</html>
