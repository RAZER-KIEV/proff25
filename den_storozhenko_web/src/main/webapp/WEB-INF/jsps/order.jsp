
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order edit</title>
</head>
<body>
<center>
<h1>Order edit</h1></center>
<font color="RED">
  ${orderEx}</font>
<form action="/create" method="POST">
  <input type="number" name="id" placeholder="Id"/><br>
  <input type="number" name="clientId" placeholder="Client id"/><br>
  <input type="text" name="amount" placeholder="Amount"/><br>
  <input type="text" name="from" placeholder="Address from"/><br>
  <input type="text" name="to" placeholder="Address to"/><br>
  <input type="submit" value="Create order"/>
</form>
<form action="/edit" method="POST">
  <input type="number" name="id" placeholder="Id"/><br>
  <input type="number" name="clientId" placeholder="Client id"/><br>
  <input type="text" name="amount" placeholder="Amount"/><br>
  <input type="text" name="from" placeholder="Address from"/><br>
  <input type="text" name="to" placeholder="Address to"/><br>
  <input type="submit" value="Edit order"/>
</form>
</body>
</html>
