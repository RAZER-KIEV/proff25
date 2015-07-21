<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register operator</title>
</head>
<body>
<center>
<h1>Register operator</h1>
  <font color="RED">
  ${authorizationEx}${error}</font>
<form action="/registersuccess.html" method="POST">
  <input type="text" name="login" placeholder="Login" onclick="if (this.value!=''){this.value='';}"/><br>
  <input type="password" name="password" placeholder="Password"/><br>
  <input type="password" name="confirmPassword" placeholder="Confirm password" /><br>
  <input type="text" name="id" placeholder="ID"/><br>
  <input type="submit" value="Register"/><br>
</form>
</center>
</body>
</html>
