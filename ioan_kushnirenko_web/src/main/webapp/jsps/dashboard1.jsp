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
    <title></title>
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
      <tr>
        <td align="center">${statu}</td>
        <td><input name="contacts[${status.index}].firstname" value="${contact.firstname}"/></td>
        <td><input name="contacts[${status.index}].lastname" value="${contact.lastname}"/></td>
        <td><input name="contacts[${status.index}].email" value="${contact.email}"/></td>
        <td><input name="contacts[${status.index}].phone" value="${contact.phone}"/></td>
      </tr>
    </c:forEach>
  </table>
  <br/>
  <input type="submit" value="Save" />

</form:form>

</body>
</html>
