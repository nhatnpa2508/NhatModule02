<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 7/25/2019
  Time: 10:53 AM
  Email: nhatnpa2508@gmail.com 
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Product Page</title>
</head>
<body>
<table cellpadding="2" cellspacing="2" border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Photo</th>
        <th>Price</th>
        <th>Buy</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id }</td>
            <td>${product.name }</td>
            <td>
                <img src="${pageContext.request.contextPath}/assets/images/${product.photo}" width="120">
            </td>
            <td>${product.price }</td>
            <td align="center">
                <a href="${pageContext.request.contextPath}/cart?action=buy&id=${product.id}">Buy</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
