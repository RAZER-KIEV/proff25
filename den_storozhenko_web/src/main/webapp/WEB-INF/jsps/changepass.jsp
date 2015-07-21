<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change password</title>
</head>
<body>
<center>
  <h1>Change password for user ${login}</h1>
  <font color="RED">${authenticateEx}${error}</font>
  <form action="/changepass.html" method="POST">
    <input type="text" name="login" placeholder="Login" value="${login}"/><br>
    <input type="password" name="password" placeholder="Password"/><br>
    <input type="password" name="newPassword" placeholder="Password"/><br>
    <input type="password" name="confirmPassword" placeholder="Password"/><br>
    <input type="submit" value="Change"/><br>
  </form>
</center>
</body>
</html>
