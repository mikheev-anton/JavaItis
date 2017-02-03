<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car list</title>
</head>
<body>
<h2>Car list</h2>
<ul>
    <li><a href="root">User list</a></li>
</ul>
<hr>
<a href="root?command=show&show=add">Add Car</a>
<hr>
<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>id</th>
        <th>Model</th>
        <th>Mileage</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${cars}" var="car">
        <%--<jsp:useBean id="cars" scope="page" type="ru.itis.jdbc.model.Car"/>--%>
        <tr>
            <td>${car.id}</td>
            <td>${car.model}</td>
            <td>${car.mileage}</td>
            <td><a href="root?command=show&show=update&id=${car.id}">Update</a></td>
            <td><a href="root?command=delete&id=${car.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
