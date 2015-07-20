<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 12.07.15
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Taxi_Login_Form</title>
    <link rel="stylesheet" href="css/style.css"></link>
</head>
<body background="bgi.jpg">


<form action="/dashboard.html" method="GET">
    <%!

    %>

    <%
    %>


    <fieldset style="border-radius: 10px 10px 10px 10px; background: white " >
        <legend style="color: orange; font-style: italic; font-size: large">AUTHENTICATION: </legend>
        <table align="left">
                <tr>
                    <td>Your login:</td>
                    <td><input type="text" name="login" value=""/><br/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="pass" name="passw" value=""><br/></td>
                </tr>
                <tr>
                    <td></td>
                    <td align="center"><input type="submit" value="Send"/></td>
                </tr>
        </table>
        <img align="right" src="nyc_taxi.jpg">
    </fieldset>


</form>
</body>
</html>
