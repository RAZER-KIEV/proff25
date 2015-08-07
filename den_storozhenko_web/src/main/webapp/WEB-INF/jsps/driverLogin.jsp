<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
  <link rel="stylesheet" href="css/index.css"/>
  <script src="js/jquery-1.11.1.js"></script>
  <script src="js/hw8.taxi/login.js"></script>
</head>
<body id="bd" onload="onLoad()">

<div id="wrapper" class="login-form" >
    <div class="header" id="header">
      <h1 id="caption">Driver login</h1>
                <span id="span">
                </span>
    </div>

    <div class="content" id="content">
      <input id="login" type="text" class="input username" placeholder="Username" />
      <input id="password" type="password" class="input password" placeholder="Password" />
        <input type="hidden" id="isLogined" value="${isLogined}"/>
    </div>
    <div class="footer" id="footer">
      <button class="button" id="button">Login</button>
    </div>
</div>
</body>
</html>
