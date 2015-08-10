<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 12.07.2015
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Successful login</title>
</head>
      <p> ${name} ${passChanged} ${successRegistration}</p>

      <p><a href="registerClientForm.html">Register client</a></p>
      <p><a href="createClientForm.html">Create client</a></p>
      <p><a href="clients.html">Show clients</a></p>
      <p><a href="clientsLastMonth.html">Show clients who have ordered in past month</a></p>
    </br>
      <p>Show clients with sum more then</p>
      <form action="/clientsSum.html" method="get">
          <input type="text" name="sum"/>
          <input type="submit" value="Show clients"/>
      </form>
    <p><a href="order.html">Create order</a></p>
    <p><a href="changeOrder.html">Change order</a></p>
    <p>Show orders with sum between</p>
    <form action="/ordersSum.html" method="get">
        <input type="text" name="sumFrom"/>
        <input type="text" name="sumTo"/>
        <input type="submit" value="Show orders"/>
    </form>
<p><a href="showAllOrders.html">Show all orders by portion</a></p>

</body>
</html>
