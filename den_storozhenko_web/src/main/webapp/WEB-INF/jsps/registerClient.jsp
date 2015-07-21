<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client registration</title>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
<div id="wrapper">
  <form name="login-form" class="login-form" action="/submitRegisterClient" method="post">
    <div class="header">
         <h1>Registration</h1>
         <span>
         <font color="BLUE">${info}</font>
         <font color="RED">${authenticateEx}${error}</font>
         </span>
    </div>

    <div class="content">
      <input type="text" name="name" class="input password" placeholder="Name"/>
      <input type="text" name="surname" class="input password" placeholder="Surname"/>
      <input type="text" name="phone" class="input password" placeholder="Phone"/>
      <input type="text" name="address" class="input password" placeholder="Address"/>
    </div>

    <div class="footer">
        <input type="submit" name="submit" value="Register" class="button"/>
        <input type="button" name="back" value="Back" class="register" onclick="location.href='/'" />
    </div>
  </form>
</div>
</body>
</html>
