<%@ page import="java.util.List" %>
<%@ page import="hw8.taxi.domain.Client" %>
<%@ page import="hw8.taxi.domain.Order" %>
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
  <title>Редактировать заказ</title>
  <link rel="stylesheet" href="css/editOrder.css">
</head>
<body>

<div id="register">
  <p><font color="RED">${info}</font></p>
  <form action="/editOrder" id="reg" method="post">
    <fieldset class="clearfix">
      Orders: <br><span class="fontawesome-user"></span><select name="order_id1">
      <% List<Order> orders = (List<Order>)request.getAttribute("orders");
        if (orders!=null)
          for(Order o:orders){
      %>
      <option value="<%=o.getOrderId() %>"><%="ID="+o.getId()+" "+o.getDate() %></option>
      <%} %>
    </select><br>
      Client: <br><span class="fontawesome-user"></span><select name="client_id1">
      <% List<Client> clients = (List<Client>)request.getAttribute("clients");
        if (clients!=null)
          for(Client c:clients){
      %>
      <option value="<%=c.getId() %>"><%=c.getName()+" "+c.getSurname() %></option>
      <%} %>
    </select><br>

      <p><input name="amount1" type="text" value="Amount" onBlur="if(this.value == '') this.value = 'Amount'" onFocus="if(this.value == 'Amount') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Username" -->
      <p><input name="addressFrom1" type="text" value="Address From" onBlur="if(this.value == '') this.value = 'Address From'" onFocus="if(this.value == 'Address From') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Username" -->
      <p><input name="addressTo1" type="text" value="Address To" onBlur="if(this.value == '') this.value = 'Address To'" onFocus="if(this.value == 'Address To') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Username" -->
      <p><input type="submit" value="Edit order"></p>
    </fieldset>
  </form>
  <p><a href="/">Назад</a><span class="fontawesome-arrow-right"></span></p>
</div>
</body>
</html>



