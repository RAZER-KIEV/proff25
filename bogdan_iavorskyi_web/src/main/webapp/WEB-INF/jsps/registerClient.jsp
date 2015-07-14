<%--
  Created by IntelliJ IDEA.
  User: bosyi
  Date: 08.07.15
  Time: 17:02
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
  <form action="createClient" method="post">
    <p>Create client</p>
    <p>Name</p>
    <input type="text" name="name">
    <br>
    <p>Surname</p>
    <input type="text" name="surname">
    <br>
    <p>Phone</p>
    <input type="text" name="phone">
    <br>
    <p>Address</p>
    <input type="text" name="address">
    <input type="hidden" name="login" value="${login}">
    <br>
    <input type="submit" value="Submit">
  </form>
</body>
</html>
