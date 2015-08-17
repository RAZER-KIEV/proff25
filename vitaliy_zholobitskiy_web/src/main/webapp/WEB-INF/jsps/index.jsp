<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добро пожаловать</title>
    <script src="js/jquery-1.11.1.js"></script>
    <script src="js/script.js"></script>
    <link rel="stylesheet" href="css/index1.css" media="screen" type="text/css" />
</head>
<body id="body">

<div id="login">
    <p><font color="RED">${info}</font></p>
    <form action="/auth.html" method="post">
        <fieldset class="clearfix">
            <p><span class="fontawesome-user"></span><input name="login" type="text" value="Логин" onBlur="if(this.value == '') this.value = 'Логин'" onFocus="if(this.value == 'Логин') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Username" -->
            <p><span class="fontawesome-lock"></span><input name="password" type="password"  value="Пароль" onBlur="if(this.value == '') this.value = 'Пароль'" onFocus="if(this.value == 'Пароль') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Password" -->
            <p><input type="submit" value="ВОЙТИ"></p>
        </fieldset>
    </form>
    <p>Нет аккаунта? &nbsp;&nbsp;<a href="/register">Регистрация</a><span class="fontawesome-arrow-right"></span></p>
</div>
<div id="1">
    Блок 1
</div>
<div id="2">
    Блок 2
</div>
<div id="3">
    Блок 3
</div>
</body>
</html>
