<%@ page import="hw8.taxi.domain.Order" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
    <link href="css/styles.css" rel="stylesheet">
</head>
<body>
<%List<Order> orders = (List<Order>)request.getAttribute("ordersList");
    if (orders!=null){%>
<table title="ORDERS" width="100%">
    <caption><H1>Orders</H1></caption>
    <thead>
    <tr>
        <th align="left">Id</th>
        <th align="left">Client</th>
        <th align="left">Address from</th>
        <th align="left">Address to</th>
        <th align="left">Amount</th>
        <th align="left">Order date</th>
    </tr>
    </thead>
    <%
        for(Order order:orders){
    %>
    <tr>
        <td><% out.println(order.getId());%></td>
        <td><% out.println(order.getClient().getFirstname()+" "+order.getClient().getLastname());%></td>
        <td><% out.println(order.getAddressFrom());%></td>
        <td><% out.println(order.getAddressTo());%></td>
        <td><% out.println(order.getAmount());%></td>
        <td><% out.println(order.getDate());%></td>
    </tr>

    <%}%>
</table>
<%} %>
</body>
</html>
