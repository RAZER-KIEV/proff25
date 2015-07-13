<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New order</title>
</head>
<body>
<h1>Order edit</h1></center>
<font color="RED">
  ${orderEx}</font>

<form action="/create1" method="POST">
  Client: <select name="names">
    <% for(String s:(List<String>)request.getAttribute("names")){
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
  <% for(String s:(List<String>)request.getAttribute("ids")){
  %>
  <option value="<%=s %>"><%=s %></option>
  <%} %>
</select><br>
  Client: <select name="names">
  <% for(String s:(List<String>)request.getAttribute("names")){
  %>
  <option value="<%=s %>"><%=s %></option>
  <%} %>
</select><br>
  <input type="text" name="amount" placeholder="Amount"/><br>
  <input type="text" name="from" placeholder="Address from"/><br>
  <input type="text" name="to" placeholder="Address to"/><br>
  <input type="submit" value="Edit order"/>
</form>
</body>
</html>
