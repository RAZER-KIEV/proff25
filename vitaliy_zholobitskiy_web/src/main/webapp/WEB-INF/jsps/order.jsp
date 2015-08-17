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
  <title>Создать заказ</title>
  <link rel="stylesheet" href="css/order.css">
</head>
<body>

<div id="register">
  <p><font color="RED">${info}</font></p>
  <form action="/createOrder" id="reg" method="post">
    <fieldset class="clearfix">

      Client: <br><span class="fontawesome-user"></span><select name="client_id">
      <% List<Client> clients = (List<Client>)request.getAttribute("clients");
        if (clients!=null)
          for(Client c:clients){
      %>
      <option value="<%=c.getId() %>"><%=c.getName()+" "+c.getSurname() %></option>
      <%} %>
    </select><br>

      <p><input name="amount" type="text" value="Amount" onBlur="if(this.value == '') this.value = 'Amount'" onFocus="if(this.value == 'Amount') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Username" -->
      <p><input name="id" type="text" value="ID" onBlur="if(this.value == '') this.value = 'ID'" onFocus="if(this.value == 'ID') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Username" -->
      <p><input name="addressFrom" type="text" value="Address From" onBlur="if(this.value == '') this.value = 'Address From'" onFocus="if(this.value == 'Address From') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Username" -->
      <p><input name="addressTo" type="text" value="Address To" onBlur="if(this.value == '') this.value = 'Address To'" onFocus="if(this.value == 'Address To') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Username" -->
      <p><input type="submit" value="Create order"></p>
    </fieldset>
  </form>
  <p><a href="/">Назад</a><span class="fontawesome-arrow-right"></span></p>
</div>
</body>
</html>
