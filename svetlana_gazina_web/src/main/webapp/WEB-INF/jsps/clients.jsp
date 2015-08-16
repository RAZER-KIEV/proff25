<%--
  Created by IntelliJ IDEA.
  User: Sveta
  Date: 8/11/2015
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Clients</title>

</head>
<body background="image/taxi.jpg">
<center>
<h1 style="color: gold">Taxi full list</h1>
<form>
  <button formaction="/dashboard"  type="submit" formmethod="post" name="Previous Page" value="Previous Page">Previous Page!</button>
</form>
<table>
  <caption><h1 style="color: gold">Clients</h1></caption>
  <thead>
  <tr style="color: gold">
    <th align="left">Id</th>
    <th align="left">Name</th>
    <th align="left">Surname</th>
    <th align="left">Phone</th>
    <th align="left">Address</th>
    <th align="left">Amount</th>
    <th align="left">Date of last order</th>
  </tr>
  </thead>
  <c:forEach var="client" items="${list}" >
    <tr style="color: gold">
      <td>${client.id}</td>
      <td>${client.name}</td>
      <td>${client.secondName}</td>
      <td>${client.phone}</td>
      <td>${client.adress}</td>
      <td>${client.sum}</td>
      <td>${client.lastOrderDay}</td>
    </tr>
  </c:forEach>
</table>
</center>
</body>
</html>
