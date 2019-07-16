<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 7/16/2019
  Time: 9:00 AM
  Email: nhatnpa2508@gmail.com 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div style="border: 1px solid #ccc; padding: 5px">
    <a href="${pageContext.request.contextPath}/uploadOneFile">Upload One File</a>
    <a href="${pageContext.request.contextPath}/uploadMultiFile">Upload Milti File</a>
</div>
</body>
</html>
