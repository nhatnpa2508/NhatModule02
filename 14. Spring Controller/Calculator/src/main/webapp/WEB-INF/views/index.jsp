<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 7/15/2019
  Time: 8:30 PM
  Email: nhatnpa2508@gmail.com 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Calculator</h2>
<form action="/calculator">
    <input type="text" name="firstNumber" value="${firstNumber}">
    <input type="text" name="secondNumber" value="${secondNumber}">
    <br>
    <input type="submit" value="+" name="operator">
    <input type="submit" value="-" name="operator">
    <input type="submit" value="*" name="operator">
    <input type="submit" value="/" name="operator">
    <br>
</form>
<h2>Result: = ${result}</h2>
</body>
</html>
