<%@ page import="hw8.taxi.domain.Operator" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Operator editing</h1>
<font color="RED">${error}</font>
<form action="/submitEditOperator" method="post">
  Operator:
  <select name="login">
    <% List<Operator> operators = (List<Operator>)request.getAttribute("operators");
      if (operators!=null)
        for(Operator o:operators){
    %>
    <option value="<%=o.getLogin()%>"><%=o.getLogin() %></option>
    <%} %>
  </select><br>
  New login: <input type="text" name="newLogin" placeholder="New login"/><br>
  New password: <input type="text" name="password" placeholder="Password"/><br>
  New role: <select name="newRole">
    <% List<String> roles = (List<String>)request.getAttribute("roles");
      if (roles!=null)
        for(String s:roles){
    %>
    <option value="<%=s%>"><%=s %></option>
    <%} %>
  </select><br>
  New ID: <input type="text" name="ident" placeholder="Id"/><br>
 <%-- <input type="checkbox" name="params[]" value = "clearAttempts"/>Clear attempts to enter wrong password<br>
  <input type="checkbox" name="params[]" value="unblock"/>Unblock operator<br>--%>
  Count attempts to enter wrong password: <input type="number" name="countAttempts" placeholder="Count attempts"/><br>
  Is blocked: <select name="isBlocked">
    <option value="true">true</option>
    <option value="false">false</option>
  </select><br>
  <input type="submit" value="Edit operator"/>
</form>
<p><font size="2px">*Leave blank to remain the same data.</font></p>
<a href="/dashboard.html">Back</a>
<form action="/logout" method="GET">
  <input type="submit" value="Log out"/>
</form>
</body>
</html>
