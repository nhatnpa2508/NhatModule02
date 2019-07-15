<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 7/15/2019
  Time: 7:52 PM
  Email: nhatnpa2508@gmail.com 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Choose Sandwich Condiments</title>
</head>
<body>
<h1>Sandwich condiments:</h1>
<form method="post" action="/save">
  <input type="checkbox" name="condiment" value="Lettuce">Lettuce
  <input type="checkbox" name="condiment" value="Tomato">Tomato
  <input type="checkbox" name="condiment" value="Mustard">Mustard
  <input type="checkbox" name="condiment" value="Sprouts">Sprouts
  <br><input type="submit" value="Save">
</form>
</body>
</html>
