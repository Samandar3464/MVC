<%--
  Created by IntelliJ IDEA.
  User: shodiyorbek
  Date: 26/01/23
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><Salom></Salom></h1>
<c:forEach items="${users}" var="item">
    <p>${item}</p>
</c:forEach>
</body>
</html>
