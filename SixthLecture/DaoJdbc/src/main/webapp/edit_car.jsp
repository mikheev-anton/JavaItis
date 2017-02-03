<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<hr/>
<ul>
    <li><a href="root">User list</a></li>
    <li><a href="root?userId=${car.ownerId}">Car list</a></li>
</ul>
<hr/>
<section>
    <h3>${param.action == 'create' ? 'Create user' : 'Edit user'}</h3>
    <form method="post" action="root?command=edit">
        <input type="hidden" name="id" value="${car.id}">
        <dl>
            <dt>Model:</dt>
            <dd><input type="text" value="${car.model}" name="model"></dd>
        </dl>
        <dl>
            <dt>Mileage:</dt>
            <dd><input type="number" value="${car.mileage}" name="mileage"></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form>
</section>
</body>
</html>
