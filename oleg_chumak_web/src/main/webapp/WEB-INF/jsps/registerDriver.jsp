<%--
  форма регистрации таксистов
  action="/newDriver.html" method="GET"
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fillForm</title>
  <script>

    function check() {
      console.log('in check');
    var nam =  document.getElementById('nm');
    var mod = document.getElementById('mdl');
    var nbr = document.getElementById('nbr');
    var tel = document.getElementById('tel');
    var form = document.getElementById('frm');
    var mess =document.getElementById('mes');

    if (nam.value !== nbr.value && nbr.value.length>=8 &&tel.length>=10)
    {
      form.action ='/newDriver.html';
      form.method = 'GET';
    }
    else {
      mess.innerHTML = 'Введены некорректные данные';
    }
  }</script>
</head>
<body >
  <h5 id="mes" style="color: red">
  </h5>
<form id="frm">
  <table>
    <tr>
      <td>Name</td>
      <td><input type="text" name="name" id="nm"></td>
    </tr>
    <tr>
      <td>Car Model</td>
      <td><input type="text" name="model" id="mdl"></td>
    </tr>
    <tr>
      <td>Car Number</td>
      <td><input type="text" name="number" id="nbr"></td>
    </tr>
    <tr>
      <td>Phone Number</td>
      <td><input type="text" name="phone" id="tel"></td>
    </tr>
    <tr>
      <td>
        <input onclick="check()" type="submit" value="CreateDriver">
      </td>
    </tr>
  </table>
</form>
</body>
</html>
