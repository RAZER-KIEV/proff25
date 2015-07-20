<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 12.07.15
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Taxi_Dashboard</title>
  <style >
    body{

      background-image: url(back2.jpg);
      background-position: left, right;
      text-align: center;
      color: darkblue;
    }
  </style>
</head>
<body>

<form:form method="post" action="save.html" modelAttribute="contactForm">
  <table>
    <tr>
      <th>No.</th>
      <th>Name</th>
      <th>Phone</th>
      <th>Car model</th>
      <th>Car number</th>
    </tr>
    <c:forEach items="${}" var="contact" varStatus="status">
    <table width="100%" >
      <tr>
        <th>No.</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Car model</th>
        <th>Car number</th>
      </tr>
      <c:forEach items="${}" var="contact" varStatus="status">
        <tr >
          <td width="10%" align="center">${statu}</td>
          <td width="25%" align="left"><input name="contacts[${status.index}].firstname" value="${contact.firstname}"/></td>
          <td width="25%" align="left"><input name="contacts[${status.index}].lastname" value="${contact.lastname}"/></td>
          <td width="20%" align="left"><input name="contacts[${status.index}].email" value="${contact.email}"/></td>
          <td width="20%" align="left"><input name="contacts[${status.index}].phone" value="${contact.phone}"/></td>
        </tr>
    </c:forEach>
  </table>
  <br/>
  <input type="submit" value="Save/Update" />

</form:form>

</body>
</html>
