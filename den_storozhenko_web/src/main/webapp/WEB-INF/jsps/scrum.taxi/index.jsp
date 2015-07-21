<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<center>
    <font color="RED">${info}</font>
  <form action="/login" method="post">
      <input name="login" type="text" placeholder="Login"/><br>
      <input name="password" type="password" placeholder="Password"><br>
      <input type="submit" value="Login">
  </form>
</center>
</body>
</html>
