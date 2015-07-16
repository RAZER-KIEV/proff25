<%@ page import="java.util.List" %>
<%@ page import="hw8.taxi.domain.Client" %>
<%--
  Created by IntelliJ IDEA.
  User: just1ce
  Date: 16.07.2015
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clients</title>
  <link rel="stylesheet" href="css/clients.css">
</head>
<body>
${def}
<ul>
<% List<Client> clients = (List<Client>)request.getAttribute("clients");
  for(Client client:clients) {
    out.println("<li>"+client.toString()+"</li>");
  }
%>
  </ul>
</body>
</html>
