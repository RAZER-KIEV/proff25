<%@ page import="java.util.List" %>
<%@ page import="scrum.domain.Driver" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Drivers</title>
    <link href="css/style.css">
</head>
<body>

<%List<Driver> drivers = (List<Driver>)request.getAttribute("drivers");
  if (drivers!=null){%>
<table title="DRIVERS" width="100%">
  <thead>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Car model</th>
    <th>Car number</th>
    <th>Phone</th>
  </tr>
  </thead>
  <%
    for(Driver driver:drivers){
  %>
  <tr>
    <td><% out.println(driver.getId());%></td>
    <td><% out.println(driver.getName());%></td>
    <td><% out.println(driver.getCarModel());%></td>
    <td><% out.println(driver.getNumber());%></td>
    <td><% out.println(driver.getPhone());%></td>
  </tr>

  <%}%>
</table>
<%} %>
</body>
</html>
