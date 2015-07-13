<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Operator authorization</title>
</head>
<body>
<h1 align="center">Operator authorization</h1>

<center>
    <font color="BLUE">${info}</font>
    <font color="RED">${authenticateEx}${error}</font>
    <form action="/dashboard.html" method="POST">
        <input type="text" name="login" placeholder="Login" value="${login}" onclick="if (this.value!=''){this.value='';}"/><br>
        <input type="password" name="password" placeholder="Password"/><br>
        <input type="submit" value="Authenticate"/><br>
    </form>
    <form action="/register.html" method="POST">
        <input type="submit" value="Register"/><br>
    </form>
</center>
</body>
</html>
