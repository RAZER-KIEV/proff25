<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 20.07.15
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%><%--
  страница с формой аутентификации
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<script src="script/JS.js"/>
<body>
<%--<p id = 'p'></p>--%>
<form action="auth" method="post">
  <table>
    <tr>
      <td>Login</td>
      <td><input id = 'login' type="text" name="login"></td>
    </tr>
    <tr>
      <td>Password</td>
      <td><input id = 'password' type="password" name="password"></td>
    </tr>
    <tr>
      <td>
        <input type="submit" value="Sign in">
      </td>
    </tr>
  </table>
</form>
<form onsubmit="auth()" action="/register.html" method="get">
  <input type="submit" value="Register">
</form>
</body>
</html>
