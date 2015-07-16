<%--
  Created by IntelliJ IDEA.
  User: ПК
  Date: 15.07.2015
  Time: 19:00
  To change this template use File | Settings | File Templates.
  зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>форма создания клиента</title>
</head>
<body>
<form action="/addClient" method="post">
  <p>Name: <input type="text" name="login"/> должен быть не менее 4 символов, не должен содержать пробелы</p>
  <p>Sur name: <input type="text" name="inn"/> идентификационный номер (10 цифр, без букв и других знаков) </p>
  <p>Phone: <input type="text" name="password"/> должен быть не менее 8 символов, включать большие и маленькие буквы, цифры</p>
  <p>adress: <input type="text" name="passwordConfirm" > должен совпадать с паролем</p>
  <p>CashSum: <input type="text" name="inn"/> идентификационный номер (10 цифр, без букв и других знаков) </p>
   <input type="submit" name="register" value="Registration"/>
</form>

</body>
</html>
