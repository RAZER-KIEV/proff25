<%@ page import="java.util.List" %>
<%@ page import="scrum.domain.Driver" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Drivers</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<%List<Driver> drivers = (List<Driver>)request.getAttribute("drivers");
  if (drivers!=null){%>
<table title="DRIVERS" width="100%">
  <caption><H1>Drivers</H1></caption>
  <thead>
  <tr>
    <td>Id</td>
    <td>Name</td>
    <td>Car model</td>
    <td>Car number</td>
    <td>Phone</td>
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
