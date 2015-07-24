<%--
  Created by IntelliJ IDEA.
  User: Well
  Date: 21.07.2015
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
  <title>Taxi Last Way</title>
  <script src="js/taxi.js"></script>
  <style>
    .bodyStyle {
      background-image: url(http://localhost:8082/imeg/street_taxi.jpg); /* Путь к фоновому изображению */
      background-color: #c7b39b;
    }
    table {
      vertical-align: middle;
    }
    p {
      font-weight: bold;
      font-style: italic
    }
  </style>

</head>
<body class="bodyStyle">

<p>Login:  <input id="login" maxlength="25" size="40"></p>
<p>Password: <input id="pass" maxlength="25" size="40"></p>

<button onclick="send()">Submit</button>

<div id="resp">bla </div>


</body>
</html>
