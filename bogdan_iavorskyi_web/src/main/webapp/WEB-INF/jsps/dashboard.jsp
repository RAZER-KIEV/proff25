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
  <p style="color: red">${dashboardMessage}</p>
  <h5>Operator: ${login}</h5>
  <form action="registerClientForm" method="post">
    <input type="hidden" name="login" value="${login}">
    <input type="submit" value="Register Client Form">
  </form>
  <form action="registerOrdersForm" method="post">
    <input type="hidden" name="login" value="${login}">
    <input type="submit" value="Register Order Form">
  </form>
  <form action="listClients" method="post">
    <input type="radio" name="clientsMode" value="default"> List all clients (without portions)<br>
    <input type="radio" name="clientsMode" value="all"> List all clients
    <input type="text" name="chunkSize"> chunk size<br>
    <input type="radio" name="clientsMode" value="sum"> List clients that have orders on sum more than<br>
    <input type="text" name="sum"><br>
    <input type="radio" name="clientsMode" value="date"> List clients that have orders over last month<br>
    <input type="hidden" name="login" value="${login}">
    <input type="submit" value="List clients">
  </form>
</body>
</html>
