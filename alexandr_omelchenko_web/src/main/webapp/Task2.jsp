<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>task2</title>
  <script src="JS/script.js">
  </script>
</head>
<body>
<p id="sr"></p>
    <table>
      <tr>
        <td>Login</td>
        <td><input type="text" name="login" id="w1"></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><input type="text" name="password" id="w2"></td>
      </tr>
    </table>

    <h2 onclick="equals()">сравнить</h2>
<button type="button"
        onclick="document.getElementById('demo').innerHTML = Date()">
  Click me to display Date and Time.</button>

<p id="demo"></p>
</body>
</html>