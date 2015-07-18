<%@ page import="taxi.domain.TaxiDriver" %>
<%@ page import="java.util.List" %>
<%--
  лист таксистов
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>drivers</title>
</head>
<body>
<%List<TaxiDriver> drivers = (List<TaxiDriver>)request.getAttribute("driversList");
  if (drivers!=null){%>
<table border="1" title="Drivers" width="100%">
  <caption><H1>Drivers</H1></caption>
  <thead>
  <tr>
    <th align="left">Id</th>
    <th align="left">Name</th>
    <th align="left">Model</th>
    <th align="left">Number</th>
    <th align="left">Phone</th>
  </tr>
  </thead>
  <%
    for(TaxiDriver dr: drivers){
  %>
  <tr>
    <td><% out.println(dr.getId());%></td>
    <td><% out.println(dr.getName());%></td>
    <td><% out.println(dr.getModel());%></td>
    <td><% out.println(dr.getNumber());%></td>
    <td><% out.println(dr.getPhone());%></td>
  </tr>

  <%}%>
</table>
<%} %>

<form action="/create.html" method="get">
        <input type="submit"  value="Create New Driver">
</form>
</body>

</html>
