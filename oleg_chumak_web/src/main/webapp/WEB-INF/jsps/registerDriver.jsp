<%--
  форма регистрации таксистов
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fillForm</title>
</head>
<body>
<form action="/newDriver.html" method="GET">
  <table>
    <tr>
      <td>Name</td>
      <td><input type="text" name="name"></td>
    </tr>
    <tr>
      <td>Car Model</td>
      <td><input type="text" name="model"></td>
    </tr>
    <tr>
      <td>Car Number</td>
      <td><input type="text" name="number"></td>
    </tr>
    <tr>
      <td>Phone Number</td>
      <td><input type="text" name="phone"></td>
    </tr>
    <tr>
      <td>
        <input type="submit" value="CreateDriver">
      </td>
    </tr>
  </table>
</form>
</body>
</html>
