<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 7/16/2019
  Time: 9:01 AM
  Email: nhatnpa2508@gmail.com 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Upload Milti File</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>
<h3>Upload Multi File</h3>
<!-- MyUploadForm-->
<form:form modelAttribute="myUploadForm" method="post" action="" enctype="multipart/form-data">
    Description
    <br>
    <form:input path="description" style="width:300px;"/>
    <br><br>
    File to upload (1): <form:input path="fileDatas" type="file"/><br>
    File to upload (2): <form:input path="fileDatas" type="file"/><br />
    File to upload (3): <form:input path="fileDatas" type="file"/><br />
    File to upload (4): <form:input path="fileDatas" type="file"/><br />
    File to upload (5): <form:input path="fileDatas" type="file"/><br />
    <input type="submit" value="Upload">
</form:form>
</body>
</html>
