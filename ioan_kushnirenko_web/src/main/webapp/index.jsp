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
    <link rel="stylesheet" href="css/style.css"/>
    <%--<script>--%>
    <%--var array = [1,2,3,4,5,6,7,8,9,0];--%>
    <%--for (var i = 0 ; i < array.length/2;i++) {--%>
    <%--var elem = array[i];--%>
    <%--array[i] = array[array.length-1-i];--%>
    <%--array[array.length-1-i] = elem;--%>
    <%--}--%>
    <%--document.write('[');--%>
    <%--document.write(array.toString());--%>
    <%--document.write(']');--%>
    <%--</script>--%>
    <script>
        var ajax = new XMLHttpRequest();
        ajax.onreadystatechange = function () {
            if (ajax.readyState == 4 && ajax.status == 200) {
                var name = document.getElementById("send");
                name.innerHTML = ajax.responseText;
            }
        };

        function send(arg) {
            var login = document.getElementById("login").value;
            ajax.open('GET', '/ajax?name=' + login);
            ajax.send();
        }
    </script>
</head>
<body background="bgi.jpg">


<form action="/dashboard.html" method="GET">
    <%!

    %>

    <%
    %>


    <fieldset style="border-radius: 10px 10px 10px 10px; background: white ">
        <legend style="color: orange; font-style: italic; font-size: large" onclick="print()">AUTHENTICATION:</legend>
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

    <table width="400px" height="250px" border="1px" style="border-style: solid">
        <tbody>
        <tr>
            <td>
                <fieldset>
                    <legend id="send">Регистрация</legend>
                    Ваш логин:<input id="login" type="text" name="login" value="Sobaka"/><br/>
                    <%--<input type="submit" value="Send"/>--%>
                    <button onclick="send()">Send</button>
                </fieldset>
            </td>
        </tr>
        </tbody>
    </table>

</form>
</body>
</html>
