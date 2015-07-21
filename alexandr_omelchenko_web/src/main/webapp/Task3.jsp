<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>task3</title>
  <script src="JS/script.js">
  </script>
</head>
<body>
<p id="mess"> Введите логин и пароль</p>
<form id="frm" onsubmit = 'check()'>
        <table>
      <tr>
        <td>Login</td>
        <td><input type="text" name="login" id="lgn"></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><input type="text" name="password" id="pwd"></td>
      </tr>
        <tr>
            <td>
                <input type="submit" value="OK">
            </td>
        </tr>
            </table>>
    </form>
</body>
</html>