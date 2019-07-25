<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 7/24/2019
  Time: 2:22 PM
  Email: nhatnpa2508@gmail.com 
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Shopping Cart Finalize</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">

</head>
<body>
<jsp:include page="_header.jsp" />

<jsp:include page="_menu.jsp" />

<div class="page-title">Finalize</div>

<div class="container">
    <h3>Thank you for Order</h3>
    Your order number is: ${lastOrderedCart.orderNum}
</div>

<jsp:include page="_footer.jsp" />

</body>
</html>
