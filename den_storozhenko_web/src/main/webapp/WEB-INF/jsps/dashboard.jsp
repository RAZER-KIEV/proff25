<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="css/dashboard.css"/>
</head>
<body>
<h1 align="center"><font color="YELLOW"> AUTHENTICATION SUCCESS<br> ${hello}</font></h1>
<font color="BLUE">${info}</font>
<font color="RED">${error}</font>
<table>
        <tr>
            <td>
                <form action="/regCl" method="GET">
                    <input type="submit" value="Register client"/>
                </form>
            </td>
        </tr>
        <tr>
                <form action="/showByPort" method="GET">
                    <td><input class="reg_title" type="submit" value="Show clients by portion"/></td>
                    <td><input  class="reg_title" type="number" name="size" value="10" placeholder="Portion size"/></td>
                </form>
        </tr>
        <tr>
                <form action="/showGtSum" method="GET">
                    <td><input class="reg_title" type="submit" value="Show clients gt sum"/></td><br>
                    <td><input class="reg_title" type="number" name="sum" value="50" placeholder="Sum"/></td>
                </form>
        </tr>
        <tr>
            <td>
                <form action="/showClientsLastMonth" method="GET">
                    <input class="reg_title" type="submit" value="Show clients last month"/>
                </form>
            </td>
        </tr>
        <tr>
            <td>
                <form action="/editOrder1" method="GET">
                    <input class="reg_title" type="submit" value="Create/edit order"/>
                </form>
            </td>
        </tr>
        <tr>
                <form action="/showOrdersBySum" method="GET">
                 <td>   <input class="reg_title" type="submit" value="Show orders by sum"/><br></td>
                    <td>   <input  class="reg_title" type="number" name="from" placeholder="From"/><br>
                    <input class="reg_title" type="number" name="to" placeholder="To"/></td>
                </form>
        </tr>
        <tr>
            <td>
                <form action="/showOrders" method="GET">
                    <input class="reg_title" type="submit" value="Show orders porced"/>
                </form>
            </td>
        </tr>
    <% if (request.getAttribute("role").equals("SUPERADMIN") || request.getAttribute("role").equals("ADMIN")){
    %>
    <tr>
        <td>
            <form action="/editOperator" method="GET">
                <input class="reg_title" type="submit" value="Edit operator"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="/unlockClear" method="GET">
                <input class="reg_title" type="submit" value="Unlock operator/clear attempts to enter password"/>
            </form>
        </td>
    </tr>
            <%}%>
    <tr>
        <td>
            <form action="/logout" method="GET">
                <input class="reg_title" type="submit" value="Log out"/>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
