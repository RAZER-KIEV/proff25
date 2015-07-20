<%--
  Created by IntelliJ IDEA.
  User: bosyi
  Date: 20.07.15
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="listAllOrders" method="post">
  <input type="submit" value="List all orders">
</form>
<form action="listOrdersByPortion" method="post">
  <input type="submit" value="List orders by portions (size 5)">
</form>
<form action="listOrdersByMoney" method="post">
  <input type="text" name="from"> Money from
  <input type="text" name="to"> Money to
  <input type="submit" value="List orders by range of money">
</form>
</body>
</html>
