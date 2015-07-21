<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Operator authorization</title>
    <link rel="stylesheet" href="css/index.css"/>
</head>
<body>
    <div id="wrapper">
        <form name="login-form" class="login-form" action="/dashboard" method="post">
            <div class="header">
                <h1>Operator Login</h1>
                <span>
                    <font color="BLUE">${info}</font>
                    <font color="RED">${authenticateEx}${error}</font>
                </span>
            </div>

            <div class="content">
                <input name="login" type="text" class="input username" placeholder="Username" />
                <input name="password" type="password" class="input password" placeholder="Password" />
            </div>

            <div class="footer">
                <input type="submit" name="submit" value="Login" class="button"/>
                <input type="button" name="register" value="Register" class="register" onclick="location.href='/register.html'" />
            </div>

        </form>
    </div>
</body>
</html>
