<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Operator authorization</title>
    <link rel="stylesheet" href="css/index.css"/>
    <script src="js/jquery-1.11.1.js"></script>
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
        function changePassword(){
            $.ajax({
                url: '/changepassword',
                type: "GET",
                data: {login: $('#login').val()},
                success: function (res) {
                    $('#header').html($('<h1>Change password</h1><span id="span"></span>'));
                    var result = $('<input type="text" id="login" class="input username" value="'+res+'"/><input type="password" class="input username" id="password" placeholder="Password"/><input type="password" class="input username" id="newPassword" placeholder="Password"/><input type="password" class="input username" id="confirmPassword" placeholder="Password"/>');
                    $('#content').html(result);
                    $('#footer').html($('<button id="change" class="button">Change password</button>'));
                }
            })
        }
        $(document).ready(function(){
            $("body").on('click', '#change', function(){
                $.ajax({
                            url: '/changepass.html',
                            type: "POST",
                            data: {login: $('#login').val(), password: $('#password').val(), newPassword: $('#newPassword').val(), confirmPassword: $('#confirmPassword').val() },
                            success: function (res) {
                                if (res==='success') {
                                    $('#header').html($('<h1>Operator login</h1><span id="span"></span>'));
                                    $('#span').html('<font id="info" color="BLUE">' + "Password for the user "+$('#login').val()+" has been changed successfully.<br>" + '</font>');
                                    $('#content').html($('<input id="login" type="text" class="input username" placeholder="Username" /><input id="password" type="password" class="input password" placeholder="Password" />'));
                                    $('#footer').html($('<input type="button" name="submit" value="Login" class="button" onclick="tryLogin()"/>'));
                                }
                                else{
                                    $('#span').html('<font id="info" color="RED">' + res + '</font>');
                                }
                            }
                        }
                )
            });
        });
    </script>
</head>
<body>
    <div id="wrapper" class="login-form">
            <div class="header" id="header">
                <h1>Operator Login</h1>
                <span id="span"></span>
            </div>

            <div class="content" id="content">
                <input id="login" type="text" class="input username" placeholder="Username" />
                <input id="password" type="password" class="input password" placeholder="Password" />
            </div>

            <div class="footer" id="footer">
                <input type="button" name="submit" value="Login" class="button" onclick="tryLogin()"/>
                <input type="button" name="register" value="Register" class="register" onclick="location.href='/register.html'" />
            </div>
    </div>
</body>
</html>
