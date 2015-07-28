<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Operator authorization</title>
    <link rel="stylesheet" href="css/index.css"/>
    <script>
        var req = new XMLHttpRequest();
        req.onreadystatechange = function(){
            if (req.readyState==4 && req.status==200){
                if (req.responseText==="dashboard"){
                    location.href='/dashboard.html';
                }
                else{
                    document.getElementById('span').innerHTML = '<span><font color="RED">'+req.responseText+'</font></span>';
                }
            }
        };
        function tryLogin(){
            var login = document.getElementById('login').value;
            var password = document.getElementById('password').value;
            req.open("POST",'/login',true);
            req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
            req.send('login='+login+'&password='+password);
        }
    </script>
</head>
<body>
    <div id="wrapper" class="login-form">
            <div class="header">
                <h1>Operator Login</h1>
                <span id="span"></span>
            </div>

            <div class="content">
                <input id="login" type="text" class="input username" placeholder="Username" />
                <input id="password" type="password" class="input password" placeholder="Password" />
            </div>

            <div class="footer">
                <input type="button" name="submit" value="Login" class="button" onclick="tryLogin()"/>
                <input type="button" name="register" value="Register" class="register" onclick="location.href='/register.html'" />
            </div>
    </div>
</body>
</html>
