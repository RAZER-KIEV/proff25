<%@ page import="hw8.taxi.domain.Operator" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="css/index.css"/>
  <script>
    var req = new XMLHttpRequest();
    req.onreadystatechange = function(){
      if (req.readyState==4 && req.status==200){
        document.getElementById('span').innerHTML = '<span>'+req.responseText+'</span>';
      }
    };
    function unlockClear(){
      var login = document.getElementById('login').value;
      req.open("POST",'/submitUnlockClear',true);
      req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
      req.send('login='+login);
    }
  </script>
</head>
<body>
<div id="wrapper" class="login-form">
  <div class="header">
    <h1>Unlock/clear</h1>
    <span id="span"></span>
  </div>
  <div class="content">
    Operator:
    <select id="login" class="input password">
      <% List<Operator> operators = (List<Operator>)request.getAttribute("operators");
        if (operators!=null)
          for(Operator o:operators){
      %>
      <option value="<%=o.getLogin()%>"><%=o.getLogin() %></option>
      <%} %>
    </select><br>
  </div>
  <div class="footer">
    <input type="button" class="button" value="Unlock/clear" onclick="unlockClear()">
    <input type="button" name="back" value="Back" class="register" onclick="location.href='/'" />
  </div>
</div>
</body>
</html>
