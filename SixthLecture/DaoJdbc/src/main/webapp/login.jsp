<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Authorisation</title>
</head>
<body>
<hr>
<form method="post" action="root?command=login">
    <dl>
        <dt>Email:</dt>
        <dd><input type="EMAIL" name="email"></dd>
    </dl>
    <dl>
        <dt>Password:</dt>
        <dd><input type="text" name="password"></dd>
    </dl>
    <button type="submit">login</button>
    <button onclick="window.history.back()">Cancel</button>
</form>
<hr/>
<ul>
    <li><a href="root?command=show&show=registration">Registration</a></li>
</ul>
<hr/>
</body>
</html>