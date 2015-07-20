
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OperatorRedactor</title>
</head>
<body>
<h3>${mess}</h3>
<form action="/redactOperator.html" method="GET">

  <table>
    <tr>
      <td>Login</td>
      <td><input type="text" name="oldLogin"></td>
    </tr>
    <tr>
      <td>NEW Login</td>
      <td><input type="text" name="newLogin"></td>
    </tr>
    <tr>
      <td>Password</td>
      <td><input type="text" name="pass"></td>
    </tr>
    <tr>
      <td>Individual Number</td>
      <td><input type="number" name="indNum"></td>
    </tr>
    <tr>
      <td>Previous Password</td>
      <td><input type="text" name="prevpass"></td>
    </tr>
    <tr>
      <td>Last Password Change Date</td>
      <td><input type="datetime-local" name="lastChangeDate"></td>
    </tr>
    <tr>
      <td>Is Blocked</td>
      <td><input type="checkbox" name="isblocked" value=true></td>
    </tr>
    <tr>
      <td>Unsuccessful Login Tries</td>
      <td><input type="number" name="unsuccTries"></td>
    </tr>
    <tr>
      <td>Admin role</td>
      <td><input type="checkbox" name="role" value="true"></td>
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