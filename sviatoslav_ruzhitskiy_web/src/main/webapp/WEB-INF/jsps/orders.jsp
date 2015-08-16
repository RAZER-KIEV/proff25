<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="hw8.taxi.domain.Client" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: ПК
  Date: 19.07.2015
  Time: 3:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>список клиентов</title>
  <link href="/css/hw8CSS.css" rel="stylesheet"/>
</head>
<body>
<div class="wrapper">
<form>
  <button formaction="/backToDashboard"  type="submit" formmethod="post" name="BacktoDASHBOARD" value="Back to DASHBOARD!">Back to DASHBOARD!</button>
</form>
<table>
  <caption><H1>Orders</H1></caption>
  <thead>
  <tr>
    <th align="left">Order Id</th>
    <th align="left">Order Date</th>
    <th align="left">Client Id</th>
    <th align="left">Amount</th>
    <th align="left">Address From</th>
    <th align="left">Address To</th>
  </tr>
  </thead>
  <c:forEach var="order" items="${list}" >
    <tr>
      <td>${order.id}</td>
      <td>${order.orderDay}</td>
      <td>${order.client.id}</td>
      <td>${order.orderSum}</td>
      <td>${order.departureAddress}</td>
      <td>${order.destinationAddress}</td>
    </tr>
  </c:forEach>
</table>
  </div>
</body>
</html>