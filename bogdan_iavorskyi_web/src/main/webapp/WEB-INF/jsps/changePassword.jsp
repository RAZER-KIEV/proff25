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
<p>Your password expired. You need to change it</p>
<p style="color: red">${changePasswordMessage}</p>
<h5>${login}</h5>
<form action="changePassword" method="post">
  <p>
    New password<br>
    Not less than 8 symbols. Need consist at last one small letter, one "big" letter and one number. Without spaces.
  </p>
  <input type="password" name="password">
  <input type="hidden" value="${login}" name="login">
  <br>
  <p>
    Password confirmation
  </p>
  <input type="password" name="passwordConfirmation">
  <br>
  <p></p>
  <input type="submit" value="Change password">
</form>
</body>
</html>
