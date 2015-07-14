<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New order</title>
</head>
<body>
<center><h1>Order edit</h1></center>
<font color="RED">
  ${orderEx}</font>

<form action="/create1" method="POST">
  Client: <select name="names">
    <% List<String> names = (List<String>)request.getAttribute("names");
      if (names!=null)
      for(String s:names){
    %>
    <option value="<%=s %>"><%=s %></option>
    <%} %>
  </select><br>
  <input type="text" name="amount" placeholder="Amount"/><br>
  <input type="text" name="from" placeholder="Address from"/><br>
  <input type="text" name="to" placeholder="Address to"/><br>
  <input type="submit" value="Create order"/>
</form>
<form action="/edit1" method="POST">
  Order: <select name="id">
  <% List<String> ids = (List<String>)request.getAttribute("ids");
    if (ids!=null)
      for(String s:ids){
  %>
  <option value="<%=s %>"><%=s %></option>
  <%} %>
</select><br>
  Client: <select name="names1">
  <%
    if (names!=null)
      for(String s:names){
  %>
  <option value="<%=s %>"><%=s %></option>
  <%} %>
</select><br>
  <input type="text" name="amount1" placeholder="Amount"/><br>
  <input type="text" name="from1" placeholder="Address from"/><br>
  <input type="text" name="to1" placeholder="Address to"/><br>
  <input type="submit" value="Edit order"/>
</form>
</body>
</html>
