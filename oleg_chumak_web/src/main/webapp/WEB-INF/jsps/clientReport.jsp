<%--
  Created by IntelliJ IDEA.
  User: GFalcon
  Date: 19.07.15
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form>
  <input type="button"
         value="List all clients"
         onclick="location.href='clientslistAll.html'"
         width="90%">
<br/>
  <input type="button"
         value="List clients to make orders for the last month"
         onclick="location.href='ClientsMadeOrdersDuringLastMonth.html'"
         width="90%">
</form>
<form action="/clientsPortinedByTen.html", method="get">
    <input type="text" name="portion">
    <input type="submit" value="List clients by portions">
</form>
<form action="/ClientsWithOrderAmountMoreThen.html", method="get">
  <input type="text" name="value">
  <input type="submit" value="List clients the amount of orders which are over">
</form>
</body>
</html>
