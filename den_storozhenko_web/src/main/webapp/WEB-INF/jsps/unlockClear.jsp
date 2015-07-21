<%@ page import="hw8.taxi.domain.Operator" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/submitUnlockClear" method="post">
  Operator:
  <select name="login">
    <% List<Operator> operators = (List<Operator>)request.getAttribute("operators");
      if (operators!=null)
        for(Operator o:operators){
    %>
    <option value="<%=o.getLogin()%>"><%=o.getLogin() %></option>
    <%} %>
  </select><br>
  <input type="checkbox" name="params[]" value = "clearAttempts"/>Clear attempts to enter wrong password<br>
  <input type="checkbox" name="params[]" value="unlock"/>Unblock operator<br>
  <input type="submit" value="Unlock/clear">
</form>
</body>
</html>
