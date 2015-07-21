<%--
  Created by IntelliJ IDEA.
  User: bosyi
  Date: 08.07.15
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<p>${message}</p>
<form action="/request.html" method="post">
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
</body>
</html>
