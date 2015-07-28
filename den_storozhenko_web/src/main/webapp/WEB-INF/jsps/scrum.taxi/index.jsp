<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="css/index.css"/>
    <script src="js/scrum.js"></script>
    <script src="js/jquery-1.11.1.js"></script>
</head>
<body>

<div id="wrapper" class="login-form">
    <table name="login-form" class="login-form">
        <div class="header">
            <h1>Operator Login</h1>
                <span>
                    <font color="BLUE">${info}</font>
                </span>
        </div>

        <div class="content">
            <input id="login" type="text" class="input username" placeholder="Username" />
            <input id="password" type="password" class="input password" placeholder="Password" />
        </div>

        <div class="footer">
            <button class="register" id="button" onclick="check()">Login</button>
        </div>

    </table>
</div>
<div id="table_div">

</div>

</body>
</html>
