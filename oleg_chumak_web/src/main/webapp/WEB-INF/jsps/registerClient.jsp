<%--
  форма создания клиента
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<h3>Welcome and fill form. Please.</h3>
<p style="color:pink">${message}</p>
<form action="backToDashboard" method="post">
  <input type="hidden" name="login" value="${login}">
  <input type="submit" value="Back to dashboard">
</form>
<form action="createClient" method="post">
  <p>Create client</p>
  <p>Name</p>
  <input type="text" name="name">
  <br>
  <p>Surname</p>
  <input type="text" name="surname">
  <br>
  <p>Phone</p>
  <input type="text" name="phone_number">
  <br>
  <p>Address</p>
  <input type="text" name="address">
  <input type="hidden" name="login" value="${login}">
  <br>
  <input type="submit" value="Submit">
</form>
</body>
</html>
