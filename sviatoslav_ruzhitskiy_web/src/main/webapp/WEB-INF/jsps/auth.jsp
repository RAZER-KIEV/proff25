<%--
  Created by IntelliJ IDEA.
  User: ПК
  Date: 10.07.2015
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentification</title>
</head>
<body>
<form action="authController" method="POST">
<p> Введите логин: <input type="text" name="login"> <br></p>
<p> Введите проль:<input type="password" name="password"></p>
  <input type="submit" name="enter" value="Log in">
  <input type="submit" name="register" value="Registeration">
</form>

</body>
</html>
