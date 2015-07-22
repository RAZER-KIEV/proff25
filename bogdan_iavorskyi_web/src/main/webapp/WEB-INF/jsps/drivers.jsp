
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>drivers</title>
  <link rel="stylesheet" href="css/style.css">
  <script src="js/script.js"></script>
</head>
<body onload=init()>
  <div id="loginField">
    <p id="message"></p>

    <table>
      <tr>
        <td>Login</td>
        <td><input type="text" name="login" id="login"></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><input type="text" name="password" id="password"></td>
      </tr>
      <button onclick = "sendTo()"> 'OK </button>
    </table>
  </div>

  <div id="tableField">
  </div>

</body>
</html>
