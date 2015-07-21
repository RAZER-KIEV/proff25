<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>AjaxT1</title>
  <script src="JS/scriptAjax.js">
  </script>
</head>
<body onload="start()">
<p id="sr">Введите значения</p>
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

<h2 onclick="ajaxF()">сравнить</h2>
</body>
</html>
