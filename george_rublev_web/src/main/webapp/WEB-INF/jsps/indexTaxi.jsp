<html>
<head>
    <title>Taxi Last Way</title>
    <link rel = "stylesheet" href="css/style.css">
    <script src="js/taxi.js"></script>
</head>
<body class="bodyStyle">

<table width="100%">
    <tr>
        <td width="20%">
            <fieldset align="right" >
                <legend align="center" >
                    <b class="title">Menu:</b></legend>
            <p id="menu">Menu is<br> locked</p>
                </fieldset>
        </td>
        <td width="55%">
            <fieldset align="right" >
                <legend align="center" >
                    <b class="title">Requested information:</b></legend>
            <p id="resp" >
                Enter Login and password!
            </p>
            </fieldset>
        </td>

        <td width="25%" id="logid">
            <%--<form action="indexTaxi.html" method="POST" style="width: 300px; padding: 10px">--%>
                <fieldset align="right" >
                    <legend align="center" >
                        <b class="title">  A u t h e n t i c a t i o n:  </b></legend>
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
                           <td class="outer" colspan="2">
                               <p>
                                 <button class="button4" onclick="send()">Submit</button>
                               </p>
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
