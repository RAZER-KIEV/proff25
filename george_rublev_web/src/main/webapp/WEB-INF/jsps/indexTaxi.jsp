<html>
<head>
    <title>Taxi Last Way</title>
    <link rel = "stylesheet" href="/css/style.css">
    <script src="/js/jquery-1.11.3.js"></script>
    <script src="/js/taxi.js"></script>

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
                Taxi light and last way. :)
            </p>
            </fieldset>
        </td>

        <td width="25%" id="logid">
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
                                     <%--<button class="button4" onclick="fun">Submit</button--%>
                               </p>
                           </td>
                            <td><p id="error"><font color="red"></font></p></td>
                        </tr>
                    </table>
                </fieldset>
    </tr>
    <tr>
        <td id="one">One</td>
        <td id="two" >Two</td>
        <td id="three">Three</td>
    </tr>
    <tr>
        <td id="four"></td>
        <td></td>
        <td></td>
    </tr>
</table>

<p id="tab">
TAB
</p>

</body>
</html>
