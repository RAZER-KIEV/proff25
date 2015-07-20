<%--
  страница с формой аутентификации
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<p>${message}</p>
<form action="auth" method="post">
  <table>
    <tr>
      <td>Login</td>
      <td><input type="text" name="login"></td>
    </tr>
    <tr>
      <td>Password</td>
      <td><input type="password" name="password"></td>
    </tr>
    <tr>
      <td>
        <input type="submit" value="Sign in">
      </td>
    </tr>
  </table>
</form>
<form action="/register.html" method="get">
  <input type="submit" value="Register">
</form>
</body>
</html>
