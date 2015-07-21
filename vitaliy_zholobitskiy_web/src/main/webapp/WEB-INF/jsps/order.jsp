<%@ page import="java.util.List" %>
<%@ page import="hw8.taxi.domain.Client" %>
<%--
  Created by IntelliJ IDEA.
  User: just1ce
  Date: 16.07.2015
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
  <link rel="stylesheet" href="css/order.css">
</head>
<body>
<tr>
  <td class="auth_title" colspan="2"><font color="RED">${info}</font> </td>
</tr>
<table>
  <tr><td> Создать заказ</td>
  </tr>
  <tr>
    <td><form action="/createOrder" method="post">
      Client: <select name="client_id">
      <% List<Client> clients = (List<Client>)request.getAttribute("clients");
        if (clients!=null)
          for(Client c:clients){
      %>
      <option value="<%=c.getId() %>"><%=c.getName()+" "+c.getSurname() %></option>
      <%} %>
    </select><br>
      <input type="text" name="amount" placeholder="Amount"/><br>
      <input type="text" name="id" placeholder="ID"/><br>
      <input type="text" name="addressFrom" placeholder="Address from"/><br>
      <input type="text" name="addressTo" placeholder="Address to"/><br>
      <input type="submit" value="Create order"/>
    </form>
    </td>
  </tr>
  <tr><td> Редактировать заказ</td>
  </tr>
  <tr>
    <td><form action="/editOrder" method="post">
      Client: <select name="client_id1">
      <%
        if (clients!=null)
          for(Client c:clients){
      %>
      <option value="<%=c.getId() %>"><%=c.getName()+" "+c.getSurname() %></option>
      <%} %>
    </select><br>
      <input type="text" name="amount1" placeholder="Amount"/><br>
      <input type="text" name="id1" placeholder="ID"/><br>
      <input type="text" name="addressFrom1" placeholder="Address from"/><br>
      <input type="text" name="addressTo1" placeholder="Address to"/><br>
      <input type="submit" value="Edit order"/>
    </form>
    </td>
  </tr>
</table>
</body>
</html>
