<%@ page import="taxi.domain.Client" %>
<%@ page import="java.util.List" %>
<%@ page import="taxi.domain.TaxiDriver" %>
<%--
  форма оформления/редактирования заказа
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="newOrder" method="post">
    <table>
        <tr>
            <td>Client</td>
            <td><select name="client">
                <%
                    List<Client> clientList = (List<Client>) request.getAttribute("clients");
                    if (clientList != null) {
                        for (Client cl: clientList) {
                %>
                <option value="<%=cl.getId()%>">
                    <%out.print(cl.getName() + " "
                        + cl.getSurname() +" | A:"+cl.getAddress()+" |Ph: "+cl.getPhoneNumber());%>
                </option>
                <%
                        }
                    }
                %>
            </select></td>
        </tr>
        <tr>
            <td>Taxi Driver</td>
            <td><select name="taxiDriver">
                <%
                    List<TaxiDriver> taxiDrivers = (List<TaxiDriver>) request.getAttribute("taxiDrivers");
                    if (taxiDrivers != null) {
                        for (TaxiDriver t: taxiDrivers) {
                %>
                <option value="<%=t.getId()%>">
                    <%out.print("N: " + t.getName() + " |M: " + t.getModel() + " |N: "
                            + t.getNumber() + " |P: " + t.getPhone());%>
                </option>
                <%
                        }
                    }
                %>
            </select></td>
        </tr>
        <tr>
            <td>Money amount (in cents)</td>
            <td><input type="text" name="moneyAmount"></td>
        </tr>
        <tr>
            <td>Address from</td>
            <td><input type="text" name="addressFrom"></td>
        </tr>
        <tr>
            <td>Address to</td>
            <td><input type="text" name="addressTo"></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="CreateOrder">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
