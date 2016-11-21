
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<section>
    <h3>${param.action == 'create' ? 'Create user' : 'Edit user'}</h3>
    <form method="post" action="users">
        <input type="hidden" name="id" value="${user.id}">
        <dl>
            <dt>Name:</dt>
            <dd><input type="text" value="${user.name}" name="name"></dd>
        </dl>
        <dl>
            <dt>Age:</dt>
            <dd><input type="number" value="${user.age}" name="age"></dd>
        </dl>
        <dl>
            <dt>City:</dt>
            <dd><input type="text" value="${user.city}" size=40 name="city"></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form>
</section>
</body>
</html>
