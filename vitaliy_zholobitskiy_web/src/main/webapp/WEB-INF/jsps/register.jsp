<%--
  Created by IntelliJ IDEA.
  User: just1ce
  Date: 15.07.2015
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Регистрация оператора</title>
    <link rel="stylesheet" href="css/register.css" media="screen" type="text/css" />
</head>
<body>
<div id="register">
  <p><font color="RED">${info}</font></p>
  <form action="/confirm_register" id="reg" method="post">
    <fieldset class="clearfix">
      <p><span class="fontawesome-user"></span><input name="login" type="text" value="Логин" onBlur="if(this.value == '') this.value = 'Логин'" onFocus="if(this.value == 'Логин') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Username" -->
      <p><span class="fontawesome-lock"></span><input name="password" type="password"  value="Пароль" onBlur="if(this.value == '') this.value = 'Пароль'" onFocus="if(this.value == 'Пароль') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Password" -->
      <p><span class="fontawesome-lock"></span><input name="confirm_password" type="password"  value="Подтвердите пароль" onBlur="if(this.value == '') this.value = 'Подтвердите пароль'" onFocus="if(this.value == 'Подтвердите пароль') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Password" -->
      <p><input type="submit" value="РЕГИСТРАЦИЯ"></p>
    </fieldset>
  </form>
  <p><a href="/">Назад</a><span class="fontawesome-arrow-right"></span></p>
</div>
</body>
</html>
