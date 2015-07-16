<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page session="false" %>
<html>
<head>
    <title>Pizza</title>
</head>
<body>
<form:form action="pizza.do" method="POST" commandName="Pizza">
    <table>
        <tr>
            <td>Id</td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><form:input path="price"/></td>
        </tr>


        <tr>
            <td colspan="2">
                <input type="submit" name="action" value="Add">
                <input type="submit" name="action" value="Edit">
                <input type="submit" name="action" value="Delete">
                <input type="submit" name="action" value="Search">
            </td>

        </tr>
    </table>
    <br>
    <table border="1">
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>

        <c:forEach items="${pizzas}" var="pizza">
            <tr>
                <td>${pizza.id}</td>
                <td>${pizza.name}</td>
                <td>${pizza.price}</td>

            </tr>
        </c:forEach>

    </table>

</form:form>
</body>
</html>
