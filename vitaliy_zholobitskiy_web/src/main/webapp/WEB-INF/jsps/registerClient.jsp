<%--
  Created by IntelliJ IDEA.
  User: just1ce
  Date: 16.07.2015
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация клиента</title>
  <link rel="stylesheet" href="css/registerClient.css">
</head>
<body>
<div id="register">
  <p><font color="RED">${info}</font></p>
  <form action="/client_register" id="reg" method="post">
    <fieldset class="clearfix">
      <p><span class="fontawesome-user"></span><input name="name" type="text" value="Имя" onBlur="if(this.value == '') this.value = 'Имя'" onFocus="if(this.value == 'Имя') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Username" -->
      <p><span class="fontawesome-user"></span><input name="surname" type="text" value="Фамилия" onBlur="if(this.value == '') this.value = 'Фамилия'" onFocus="if(this.value == 'Фамилия') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Username" -->
      <p><span class="fontawesome-user"></span><input name="address" type="text" value="Адресс" onBlur="if(this.value == '') this.value = 'Адресс'" onFocus="if(this.value == 'Адресс') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Username" -->
      <p><span class="fontawesome-user"></span><input name="phone" type="text" value="Телефон" onBlur="if(this.value == '') this.value = 'Телефон'" onFocus="if(this.value == 'Телефон') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Username" -->
      <p><input type="submit" value="РЕГИСТРАЦИЯ"></p>
    </fieldset>
  </form>
  <p><a href="/">Назад</a><span class="fontawesome-arrow-right"></span></p>
</div>
</body>
</html>
