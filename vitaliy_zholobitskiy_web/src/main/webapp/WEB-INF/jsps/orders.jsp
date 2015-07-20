<%@ page import="hw8.taxi.domain.Order" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: just1ce
  Date: 17.07.2015
  Time: 0:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link rel="stylesheet" href="css/orders.css">
</head>
<body>
${def}
<ul>
  <% List<Order> orders = (List<Order>)request.getAttribute("orders");
    for(Order order:orders) {
      out.println("<li>"+order.toString()+"</li>");
    }
  %>
</ul>

</body>
</html>
