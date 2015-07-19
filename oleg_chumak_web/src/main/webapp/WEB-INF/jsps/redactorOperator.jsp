
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OperatorRedactor</title>
</head>
<body>
<h3>${message}</h3>
<form action="/redactOperator.html" method="GET">

  <table>
    <tr>
      <td>Old Login</td>
      <td><input type="text" name="oldLogin" value=""></td>
    </tr>
    <tr>
      <td>NEW Login</td>
      <td><input type="text" name="newLogin" value=""></td>
    </tr>
    <tr>
      <td>Password</td>
      <td><input type="text" name="pass" value=""></td>
    </tr>
    <tr>
      <td>Individual Number</td>
      <td><input type="number" name="indNum" value=""></td>
    </tr>
    <tr>
      <td>Previous Password</td>
      <td><input type="text" name="prevpass" value=""></td>
    </tr>
    <tr>
      <td>Last Password Change Date</td>
      <td><input type="datetime-local" name="lastChangeDate" value=""></td>
    </tr>
    <tr>
      <td>Is Blocked</td>
      <td><input type="text" name="isblocked"></td>
    </tr>
    <tr>
      <td>Unsuccessful Login Tries</td>
      <td><input type="number" name="unsuccTries"></td>
    </tr>
    <tr>
      <td>
        <input type="submit" value="OK">
      </td>
    </tr>
  </table>

</form>
</body>
</html>