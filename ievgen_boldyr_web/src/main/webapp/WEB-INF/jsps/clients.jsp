<%@ page import="web.domain.Client" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 12.07.15
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border="0" align="centre" TITLE="CLIENT" width="70%">
  <%--<tr>--%>

    <%--<td><h2>Taxi's clients</h2></td>--%>

  <%--</tr>--%>
  <tr>
    <td align="centre">

      <form action="/dashboard.html" method="get" >
        <input type="text" name="login" value="Login" align="centre"/>
        <input type="password" name="paswwd" value="password"/>
        <input type="submit" value="send"/>
      </form>

    </td>
  </tr>
</table>

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
