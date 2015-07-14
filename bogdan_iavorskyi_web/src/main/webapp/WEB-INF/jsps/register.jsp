<%--
  Created by IntelliJ IDEA.
  User: bosyi
  Date: 08.07.15
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h3>TAXI 102</h3>
<p style="color: red">${registerMessage}</p>
<form action="register" method="post">
  <p>
    Login<br>Not less than 4 symbols, without spaces.
  </p>
  <input type="text" name="login">
  <br>
  <p>
    Password<br>
    Not less than 8 symbols. Need consist at last one small letter, one "big" letter and one number. Without spaces.
  </p>
  <input type="password" name="password">
  <br>
  <p>
    Password confirmation
  </p>
  <input type="password" name="passwordConfirmation">
  <br>
  <p>
    Individual taxpayer number
  </p>
  <input type="text" name="individualTaxpayerNumber">
  <p></p>
  <input type="submit" value="Register">
</form>
</body>
</html>
