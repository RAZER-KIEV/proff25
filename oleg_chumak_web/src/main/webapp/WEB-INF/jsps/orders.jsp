<%@ page import="taxi.domain.Order" %>
<%@ page import="java.util.List" %>
<%--
  список заказов
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="css/style.css">
    <script>
        var val = '33';
//        console.log(val);
        document
    </script>
</head>
<body>
<table style="width: auto">
    <thead>
    <th>Id</th>
    <th>Client</th>
    <th>TaxiDriver</th>
    <th>Money amount</th>
    <th>Address from</th>
    <th>Address to</th>
    </thead>
    <%
        List<Order> orderList = (List<Order>) request.getAttribute("orders");
        if (orderList != null) {
    %>
    <tbody>
    <%
            for (Order or : orderList) {
    %>
    <tr>
        <td><%out.print(or.getId());%></td>
        <td><%out.print("ID: "+or.getClient().getId() + "|NAME: " + or.getClient().getName() + " " + or.getClient().getSurname());%></td>
        <td><%out.print("ID: "+or.getTaxiDriver().getId() + "|NAME: " + or.getTaxiDriver().getName());%></td>
        <td><%out.print(or.getAmount());%></td>
        <td><%out.print(or.getAddressFrom());%></td>
        <td><%out.print(or.getAddressTo());%></td>
    </tr>
    <%
            }
    %>
    </tbody>
    <%
        }
    %>
</table>
</body>
</html>
