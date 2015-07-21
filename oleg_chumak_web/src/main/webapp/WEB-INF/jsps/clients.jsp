<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17.07.2015
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="taxi.domain.Client" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Clients list</title>

</head>
<body>
<%List<Client> clients = (List<Client>)request.getAttribute("clientList");
  if (clients!=null){%>
<table title="CLIENTS" width="100%">
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
  <%
    for(Client client:clients){
  %>
  <tr>
    <td><% out.println(client.getId());%></td>
    <td><% out.println(client.getFirstname());%></td>
    <td><% out.println(client.getLastname());%></td>
    <td><% out.println(client.getPhone());%></td>
    <td><% out.println(client.getAdress());%></td>
    <td><% out.println(client.getCash());%></td>
    <td><% out.println(client.getDateLastOrder());%></td>
  </tr>

  <%}%>
</table>
<%} %>
</body>
</html>
