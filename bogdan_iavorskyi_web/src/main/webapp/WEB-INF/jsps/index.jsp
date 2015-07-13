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
<h3>TAXI 102</h3>
<p style="color: red">${indexMessage}</p>
  <table>
    <thead></thead>
    <tbody>
      <tr>
        <td>
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
        </td>
      </tr>
      <tr>
        <td>
          <form action="register.html" method="get">
            <input type="submit" value="Register">
          </form>
        </td>
      </tr>
      <tr>
        <td>
          <form action="timeMachine" method="post">
            Login<br>
            <input type="text" name="login"><br>
            <input type="submit" value="Change time">
          </form>
        </td>
      </tr>
    </tbody>
    <tfoot></tfoot>
  </table>
</body>
</html>
