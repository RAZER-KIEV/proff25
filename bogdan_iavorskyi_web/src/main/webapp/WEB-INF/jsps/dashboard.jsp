<%@ page import="scrum.domain.Taxi" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: bosyi
  Date: 08.07.15
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <p>${message}</p>
  <%
    List<Taxi> clientList = (List<Taxi>) request.getAttribute("taxists");
    if (clientList != null) {
      for(Taxi client:clientList) {
  %>
  <tr>
    <td>
      <%=client.getName()
      %>
    </td>
    <td>
      <%out.print(client.getMarka());
      %>
    </td>
    <td>
      <%out.print(client.getNumber());
      %>
    </td>
    <td>
      <%out.print(client.getTelefon());
      %>
    </td>
  </tr>
  <%
      }
    }
  %>
</body>
</html>
