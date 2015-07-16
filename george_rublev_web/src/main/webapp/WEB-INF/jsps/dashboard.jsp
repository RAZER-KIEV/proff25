<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 12.07.15
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="web.domain.Client"%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%--<H2>Dashboard new</H2>--%>

<%List<Client> clients = (List<Client>)request.getAttribute("clientList");
  if (clients!=null){%>
<table title="CLIENTS" width="80%" border="1" align="center">
  <caption><H1>Clients of Taxi</H1></caption>
  <thead>
  <tr>
    <th align="left">Id</th>
    <th align="left">Name</th>
    <th align="left">Phone</th>
  </tr>
  </thead>
  <%
    for(Client client:clients){
  %>
  <tr>
    <td><% out.println(client.getId());%></td>
    <td><% out.println(client.getName());%></td>
    <td><% out.println(client.getPhone());%></td>
  </tr>

  <%}%>
</table>
<%} %>

</body>
</html>
