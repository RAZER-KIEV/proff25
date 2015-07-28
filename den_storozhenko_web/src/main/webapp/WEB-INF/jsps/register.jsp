<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register operator</title>
    <link rel="stylesheet" href="css/index.css">
    <script>
        var req = new XMLHttpRequest();
        req.onreadystatechange = function(){
            if (req.readyState==4 && req.status==200){
                document.getElementById('span').innerHTML = '<span>'+req.responseText+'</span>';
            }
        };
        function tryRegister(){
            var login = document.getElementById('login').value;
            var password = document.getElementById('password').value;
            var confirmPassword = document.getElementById('confirmPassword').value;
            var ident = document.getElementById('ident').value;
            req.open("POST",'/registerSuccess',true);
            req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
            req.send('login='+login+'&password='+password+'&confirmPassword='+confirmPassword+'&ident='+ident);
        }
    </script>
</head>
<body>
<div id="wrapper" class="login-form">
    <div class="header">
        <h1>Register operator</h1>
        <span id="span"></span>
    </div>

    <div class="content">
      <input type="text" class="input password" id="login" placeholder="Login"/>
      <input type="password" class="input password" id="password" placeholder="Password"/>
      <input type="password" class="input password" id="confirmPassword" placeholder="Confirm password" />
      <input type="text" class="input password" id="ident" placeholder="ID"/>
    </div>

    <div class="footer">
      <input type="button" class="button" value="Register" onclick="tryRegister()"/>
      <input type="button" name="back" value="Back" class="register" onclick="location.href='/'" />
    </div>
</div>
</body>
</html>
