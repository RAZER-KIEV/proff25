<%@ page import="scrum.taxi.domain.Driver" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

  <%List<Driver> drivers = (List<Driver>)request.getAttribute("drivers");
    if (drivers!=null){%>
  <table title="DRIVERS" width="100%">
    <tr>
      <td><strong>Id</strong></td>
      <td><strong>Name</strong></td>
      <td><strong>Surname</strong></td>
      <td><strong>Phone</strong></td>
      <td><strong>Car number</strong></td>
    </tr>
  <%
      for(Driver driver:drivers){
  %>
  <tr>
    <td><% out.println(driver.getId());%></td>
    <td><% out.println(driver.getName());%></td>
    <td><% out.println(driver.getSurname());%></td>
    <td><% out.println(driver.getPhone());%></td>
    <td><% out.println(driver.getNumber());%></td>
  </tr>

  <%}%>
  </table>
  <%} %>

</body>
</html>
