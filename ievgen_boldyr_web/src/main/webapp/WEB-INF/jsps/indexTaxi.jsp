<%--
  Created by IntelliJ IDEA.
  User: Well
  Date: 21.07.2015
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Taxi Last Way</title>
    <script src="js/taxi.js"></script>
    <style>
        .bodyStyle {
            background-image: url(http://localhost:8082/imeg/street_taxi.jpg); /* Путь к фоновому изображению */
            /*background-color: #c7b39b;*/
            opacity: 0.8;
            background-position: left, right;
        }

        table {
            vertical-align: middle;
        }

        p {
            font-weight: bold;
            font-style: italic
        }
    </style>

</head>
<body class="bodyStyle">

<%--<p>Login:  <input id="login" maxlength="25" size="40"></p>--%>
<%--<p>Password: <input id="pass" maxlength="25" size="40"></p>--%>

<%--<button onclick="send()">Submit</button>--%>


<table>
    <tr height="400px"></tr>
    <tr>
        <td width="35%"><p id="menu"></p> </td>
        <td width="35%"><p id="resp"></p></td>
        <td width="30%" id="logid">
            <%--<form action="indexTaxi.html" method="POST" style="width: 300px; padding: 10px">--%>
                <fieldset align="right"
                          style="border-style: solid; border-radius: 10px 10px 10px 10px; border-color: black; background-color: #FCCC56 ">
                    <legend align="center"
                            style="border-radius: 10px 10px 10px 10px; border-style: solid; border-width: 2px; background-color: #E6A37E; padding:  ">
                        <b
                                style="font-family: Arial; font-weight: bold">Authentication:</b></legend>
                    <table>
                        <tr>
                            <td>Login:</td>
                            <td><input id="login" type="text"/><br/></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input id="pass" type="password"/><br/></td>
                        </tr>
                        <tr>
                            <td>
                                <button onclick="send()">Submit</button>
                            </td>
                            <td><p id="error"><font color="red"></font></p></td>
                        </tr>
                    </table>
                </fieldset>
            <%--</form>--%>
    </tr>
</table>

</body>
</html>
