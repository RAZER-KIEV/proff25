<%@ page import="hw8.taxi.domain.Client" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 17.07.2015
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All clients</title>
</head>
<body>
<table width="100%">
  <td align="left">
    <p>${massage}</p>
    <%
      List<Client> list = (List<Client>)request.getAttribute("list");
      for(Client cl : list) {
                out.print(cl + "</br>");
      }
    %>
    <p>${next}</p>
  </td>
</table>
</body>
</html>
