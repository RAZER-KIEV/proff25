<%--
  Created by IntelliJ IDEA.
  User: ПК
  Date: 12.07.2015
  Time: 3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link href="/css/hw8CSS.css" rel="stylesheet"/>
</head>
<body>
<form action="/addUser" method="post">
  <p>Login: <input type="text" name="login"/> должен быть не менее 4 символов, не должен содержать пробелы</p>
  <p>INN: <input type="text" name="inn"/> идентификационный номер (10 цифр, без букв и других знаков) </p>
  <p>Password: <input type="password" name="password"/> должен быть не менее 8 символов, включать большие и маленькие буквы, цифры</p>
  <p>Password confirm: <input type="password" name="passwordConfirm" > должен совпадать с паролем</p>
 <input type="submit" name="register" value="Registration"/>

</form>
</body>
</html>
