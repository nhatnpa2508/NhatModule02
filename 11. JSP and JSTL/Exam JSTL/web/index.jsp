<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 6/15/2019
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>c:out example</title></head>
<body>
<h2>c:out example</h2>
<c:out value="${'This is true: 10 > 1 '}" />
<br/>
Tag: <c:out value="${'<atag> , &'}"/>
</body>
</html>
