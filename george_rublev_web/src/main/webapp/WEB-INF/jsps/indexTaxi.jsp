<html>
<head>
    <title>Taxi Last Way</title>
    <link rel = "stylesheet" href="css/style.css">
    <script src="js/taxi.js"></script>
</head>
<body class="bodyStyle">

<%--<p>Login:  <input id="login" maxlength="25" size="40"></p>--%>
<%--<p>Password: <input id="pass" maxlength="25" size="40"></p>--%>

<%--<button onclick="send()">Submit</button>--%>

<table>
    <tr height="250px"></tr>
    <tr>
        <td width="37%"><p id="menu"></p> </td>
        <td width="35%"><p id="resp"></p></td>
        <td width="28%" id="logid">
            <%--<form action="indexTaxi.html" method="POST" style="width: 300px; padding: 10px">--%>
                <fieldset align="right">
                    <legend align="center">
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
