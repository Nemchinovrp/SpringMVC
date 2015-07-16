<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <link href="<c:url value="/resources/css/default.css" />" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Pizza</title>
</head>
<body>
<body>
<h1>Наименование</h1>

<ul class="boxLogin">
    <c:forEach var="p" items="${pizzas}">
        <li>${p.id} - ${p.name} - ${p.price}</li>
    </c:forEach>
</ul>

</body>
</body>
</html>