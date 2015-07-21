<%@ page import="hw8.Client" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: bosyi
  Date: 14.07.15
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%!
  int counter;
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
<p class="brown">Counter: <%
  out.print(++counter);
%></p>
<div>
  something
</div>
<table id="table" class="brown" style="width: auto">
<%
  List<Client> clientList = (List<Client>) request.getAttribute("clients");
  if (clientList != null) {
    for(Client client:clientList) {
%>
<tr>
  <td>
    <%=client.getName()
    %>
  </td>
  <td>
    <%out.print(client.getName());
    %>
  </td>
  <td>
    <%out.print(client.getAddress());
    %>
  </td>
</tr>
<%
    }
  }
%>
</table>
</body>
</html>
