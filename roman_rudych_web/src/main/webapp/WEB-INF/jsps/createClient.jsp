<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 16.07.2015
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <h2 align="center">Create client</h2>
</head>
<body>
<title>
  Create client
</title>

<table border="0" cellspacing="20" width="100%">
  <form action="/createClient.html" method="post">
    <tr>
      <th align="right"><strong>Name: </strong></th>
      <th align="left"><input type="text" name="name"/></th>
    </tr>
    <tr>
      <th align="right"><strong>Surname: </strong></th>
      <th align="left"><input type="text" name="surname"/> </th>
    </tr>
    <tr>
      <th align="right"><strong>Phone number: </strong></th>
      <th align="left"> <input type="text" name="phoneNum"/> </th>
    </tr>
    <tr>
      <th align="right"><strong>Address: </strong></th>
      <th align="left"><input type="text" name="address"/> </th>
    </tr>
    <tr align="center">
      <p><font color="red"> ${warning}</font> </p>
    </tr>
    <tr>
      <th align="right"></th>
      <th align="left"> <input type="submit" value="Create"/> </th>
    </tr>

  </form>

</table>
</body>
</html>
