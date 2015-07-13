<%--
  Created by IntelliJ IDEA.
  User: bosyi
  Date: 13.07.15
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <h3>TAXI 102</h3>
  <p style="color: red">${message}</p>
  <form action="backToDashboard" method="post">
    <input type="hidden" name="login" value="${login}">
    <input type="submit" value="Back to dashboard">
  </form>

  <form action="createOrder" method="post">
    <p>Client ID</p>
    <input type="text" name="clientID">
    <br>
    <p>Money amount</p>
    <input type="text" name="amount">
    <br>
    <p>Address from</p>
    <input type="text" name="addressFrom">
    <br>
    <p>Address to</p>
    <input type="text" name="addressTo">
    <br>
    <input type="hidden" name="login" value="${login}">
    <input type="submit" value="Create">
  </form>
</body>
</html>
