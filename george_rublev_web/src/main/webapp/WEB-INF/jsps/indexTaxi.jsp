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

<table width="100%" bgcolor="#f0ffff">
    <tr>
        <td width="20%"><p id="menu"></p> </td>
        <td width="55%"><p id="resp"></p></td>
        <td width="25%" >
            <fieldset align="center" style="border-style: solid; border-radius: 10px 10px 10px 10px; border-color: black; background-color: #FCCC56 ">

            <table border="0"   id="logid">
                <tr>
                    <td>
                        <legend align="center" style="border-radius: 10px 10px 10px 10px; border-style: solid; border-width: 2px; background-color: #E6A37E;">
                            <b style="font-family: Arial; font-weight: bold" >Authentication:</b></legend>
                    </td>
                </tr>
                <tr>
                    <td>Login:</td>
                    <td><input id="login" type="text"/><br></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input id="pass" type="password"/><br></td>
                </tr>
                <tr>
                    <td>
                        <button onclick="send('send')">Submit</button>
                    </td>
                    <td><p id="error" color="red"> </p></td>
                </tr>
            </table>
            </fieldset>
        </td>




    </tr>
</table>

</body>
</html>
