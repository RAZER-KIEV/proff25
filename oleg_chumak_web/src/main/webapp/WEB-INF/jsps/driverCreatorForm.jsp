<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 17.07.2015
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fillForm</title>
</head>
<body>
<form action="/newDriver.html" method="GET">
  <table>
    <tr>
      <td>Login</td>
      <td><input type="text" name="name"></td>
    </tr>
    <tr>
      <td>Model</td>
      <td><input type="text" name="model"></td>
    </tr>
    <tr>
      <td>CarNumber</td>
      <td><input type="text" name="number"></td>
    </tr>
    <tr>
      <td>PhoneNum</td>
      <td><input type="text" name="phone"></td>
    </tr>
    <tr>
      <td>
        <input type="submit" value="CreateDriver">
      </td>
    </tr>
  </table>
</form>
</body>
</html>
