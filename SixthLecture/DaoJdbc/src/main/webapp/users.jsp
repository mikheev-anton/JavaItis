<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User list</title>
</head>
<body>
<h2>User list</h2>
<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Age</th>
        <th>City</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <jsp:useBean id="user" scope="page" type="ru.itis.jdbc.model.User"/>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.city}</td>
        </tr>
    </c:forEach>
</table>
<ul>
    <li><a href="root?userId=${user.id}">My car list</a></li>
</ul>
</body>
</html>
