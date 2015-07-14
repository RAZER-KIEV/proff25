<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: bosyi
  Date: 13.07.15
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/create1" method="GET">
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
</body>
</html>
