<%@ page import="taxi.domain.Operator" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 18.07.2015
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>redactorOperator</title>
</head>
<body>
<%Operator oper = (Operator)request.getAttribute("operator")%>
<form action="/newDriver.html" method="GET">
  <table>
    <tr>
      <td>Login</td>
      <td><input type="text" name="name"></td>
    </tr>
    <tr>
      <td>Password</td>
      <td><input type="text" name="model"></td>
    </tr>
    <tr>
      <td>Individual Number</td>
      <td><input type="text" name="number"></td>
    </tr>
    <tr>
      <td>Previous Password</td>
      <td><input type="text" name="phone"></td>
    </tr>
    <tr>
      <td>Is Blocked</td>
      <td><input type="text" name="phone"></td>
    </tr>
    <tr>
      <td>Unsuccessful Login Tries</td>
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
