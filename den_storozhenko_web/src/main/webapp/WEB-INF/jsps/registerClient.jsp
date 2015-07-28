<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client registration</title>
    <link rel="stylesheet" href="css/index.css">
    <script>
        var req = new XMLHttpRequest();
        req.onreadystatechange = function(){
            if (req.readyState==4 && req.status==200){
                document.getElementById('span').innerHTML = req.responseText;
                document.getElementById('name').value = "";
                document.getElementById('surname').value = "";
                document.getElementById('phone').value = "";
                document.getElementById('address').value = "";
            }
        };
        function tryRegisterClient(){
            var name = document.getElementById('name').value;
            var surname = document.getElementById('surname').value;
            var phone = document.getElementById('phone').value;
            var address = document.getElementById('address').value;
            req.open("POST",'/submitRegisterClient',true);
            req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
            req.send('name='+name+'&surname='+surname+'&phone='+phone+'&address='+address);
        }
    </script>
</head>
<body>
<div id="wrapper" class="login-form">
    <div class="header">
         <h1>Client registration</h1>
         <span id="span"></span>
    </div>

    <div class="content">
      <input type="text" id="name" class="input password" placeholder="Name"/>
      <input type="text" id="surname" class="input password" placeholder="Surname"/>
      <input type="text" id="phone" class="input password" placeholder="Phone"/>
      <input type="text" id="address" class="input password" placeholder="Address"/>
    </div>

    <div class="footer">
        <input type="button" name="submit" value="Register" class="button" onclick="tryRegisterClient()"/>
        <input type="button" name="back" value="Back" class="register" onclick="location.href='/'" />
    </div>
</div>
</body>
</html>
