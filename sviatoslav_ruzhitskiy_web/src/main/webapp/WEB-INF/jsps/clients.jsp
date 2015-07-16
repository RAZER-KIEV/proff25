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
</head>
<body>
<h1 align="center">Taxi full list</h1>
<div>
  <%
    List<Client> list = (List<Client>)request.getAttribute("list");
    for (Client client : list) {
      out.println(client);
    }
  %>
</div>

</body>
</html>
