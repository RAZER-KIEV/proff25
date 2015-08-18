<%--
  Created by IntelliJ IDEA.
  User: Sveta
  Date: 8/17/2015
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Orders</title>
</head>
<body background="image/taxi.jpg">
<center>

<table>
  <caption style="color: gold"><h1>Orders</h1></caption>
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
    <form>
        <button formaction="/dashboard"  type="submit" formmethod="post" name="password" value="password" style="border-radius: 5px">Back!</button>
    </form>
</center>
</body>
</html>
