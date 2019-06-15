<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 6/15/2019
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
  <title>Product Discount Calculator</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Product</h2>
<form action="/calculator" method="post">
  Product Description<input type="text" name="product" placeholder="Mô tả của sản phẩm "/><br>
  List Price<input type="text" name="price" placeholder="Giá niêm yết của sản phẩm"/><br>
  Discount Percent<input type="text" name="percent" placeholder="Tỷ lệ chiết khấu %"/><br>
  <input type = "submit" id = "submit" value = "Calculator"/>
</form>
</body>
</html>
