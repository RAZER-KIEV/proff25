<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register operator</title>
  <link rel="stylesheet" href="css/index.css">
</head>
<body>
<div id="wrapper">
  <form name="login-form" class="login-form" action="/registersuccess.html" method="post">
    <div class="header">
      <h1>Register operator</h1>
 <span>
 <font color="BLUE">${info}</font>
 <font color="RED">${authenticateEx}${error}</font>
 </span>
    </div>

    <div class="content">
      <input type="text" class="input password" name="login" placeholder="Login" onclick="if (this.value!=''){this.value='';}"/>
      <input type="password" class="input password" name="password" placeholder="Password"/>
      <input type="password" class="input password" name="confirmPassword" placeholder="Confirm password" />
      <input type="text" class="input password" name="id" placeholder="ID"/>
    </div>

    <div class="footer">
      <input type="submit" class="button" value="Register"/>
      <input type="button" name="back" value="Back" class="register" onclick="location.href='/'" />
    </div>

  </form>
</div>
</body>
</html>
