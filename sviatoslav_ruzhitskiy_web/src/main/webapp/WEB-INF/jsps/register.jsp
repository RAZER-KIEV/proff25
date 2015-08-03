<%--
  Created by IntelliJ IDEA.
  User: ПК
  Date: 12.07.2015
  Time: 3:41
  J2tGxYAp
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link href="/css/hw8CSS.css" rel="stylesheet"/>
  <script src="js/jquery-1.11.1.js"></script>
  <script src="js/registrationScript.js"></script>
</head>
<body>


<p id="info"></p>
<fieldset>
  <legend>Registration</legend>

  <p>Login: <input id="login" type="text" name="login"/> должен быть не менее 4 символов, не должен содержать пробелы</p>
  <p>INN: <input id="inn" type="text" name="inn"/> идентификационный номер (10 цифр, без букв и других знаков) </p>
  <p>Password: <input id="password" type="password" name="password"/> должен быть не менее 8 символов, включать большие и маленькие буквы, цифры</p>
  <p>Password confirm: <input id="passwordConfirm" type="password" name="passwordConfirm" > должен совпадать с паролем</p>
  <input id="submit" type="submit" name="register" value="Registration" onclick="check()"/>
  <form>
  <button id="authenticateButton" formaction="/"  type="submit" formmethod="post" css="">Go to Authenticate!!</button>
  </form>
</fieldset>
</body>
</html>
