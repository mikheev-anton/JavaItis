<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<div>
    <form method="post" action="root?command=registration">
        <dl>
            <dt>Name:</dt>
            <dd><input type="text" name="name"></dd>
        </dl>
        <dl>
            <dt>Age:</dt>
            <dd><input type="number" name="age"></dd>
        </dl>
        <dl>
            <dt>City:</dt>
            <dd><input type="text" name="city"></dd>
        </dl>
        <dl>
            <dt>Email:</dt>
            <dd><input type="email" name="email"></dd>
        </dl>
        <dl>
            <dt>Password:</dt>
            <dd><input type="password" name="password"></dd>
        </dl>
        <button type="submit">Regist</button>
        <button onclick="window.history.back()">Cancel</button>
    </form>
</div>
</body>
</html>
