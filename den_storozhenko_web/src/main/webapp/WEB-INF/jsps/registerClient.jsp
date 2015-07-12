<%--
  Created by IntelliJ IDEA.
  User: storo_000
  Date: 10.07.2015
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client registration</title>
</head>
<body>
<font color="BLUE">${info}</font>
<font color="RED">${error}</font>
<form action="registerClient" method="POST">
  <input type="text" name="name" placeholder="Name"/><br>
  <input type="text" name="surname" placeholder="Surname"/><br>
  <input type="text" name="phone" placeholder="Phone"/><br>
  <input type="text" name="address" placeholder="Address"/><br>
  <input type="submit" value="Register"/>
</form>
</body>
</html>
