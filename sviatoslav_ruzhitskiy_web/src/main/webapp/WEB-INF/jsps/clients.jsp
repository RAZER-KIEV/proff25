<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="hw8.taxi.domain.Client" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: ПК
  Date: 15.07.2015
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>список клиентов</title>
  <link href="/css/hw8CSS.css" rel="stylesheet"/>
</head>
<body>
<h1 align="center">Taxi full list</h1>
<form>
  <button formaction="/backToDashboard"  type="submit" formmethod="post" name="BacktoDASHBOARD" value="Back to DASHBOARD!">Back to DASHBOARD!</button>
</form>
<table>
   <caption><H1>Clients</H1></caption>
   <thead>
   <tr>
    <th align="left">Id</th>
    <th align="left">Name</th>
    <th align="left">Surname</th>
    <th align="left">Phone</th>
    <th align="left">Address</th>
    <th align="left">Amount</th>
    <th align="left">Date last order</th>
   </tr>
   </thead>
  <c:forEach var="client" items="${list}" >
    <tr>
      <td>${client.id}</td>
      <td>${client.name}</td>
      <td>${client.secondName}</td>
      <td>${client.phone}</td>
      <td>${client.adress}</td>
      <td>${client.summ}</td>
      <td>${client.lastOrderDay}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
