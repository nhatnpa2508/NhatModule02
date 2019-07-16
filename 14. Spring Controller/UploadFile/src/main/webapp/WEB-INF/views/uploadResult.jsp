<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 7/16/2019
  Time: 9:01 AM
  Email: nhatnpa2508@gmail.com 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Upload Result</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>
<h3>Uploaded Files: </h3>
Description: ${description}
<br>
<c:forEach items="${uploadedFiles}" var="file">
    - ${file}<br>
</c:forEach>
</body>
</html>
