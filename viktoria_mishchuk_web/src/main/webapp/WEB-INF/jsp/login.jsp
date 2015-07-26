<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 06.07.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task</title>
    <script src="js/checkAjax.js"></script>
</head>
<body>
<c:out value="${name}"/>
<fieldset>
    <legend id="send">Регистрация</legend>
    Ваш логин:<input id="login" type="text" name="login" value="Sobaka"/><br/>
    <%--<input type="submit" value="Send"/>--%>
    <button onclick="send()">Send</button>
</fieldset>

<%--<p> <input id="val1" maxlength="25" size="40" value="">LOGIN</p>--%>
<%--<p> <input id="val2" maxlength="25" size="40" value="">PASSWORD</p>--%>
<%--<button onclick="checkAjax(document.getElementById('val1'))">OK</button>--%>

<table  style="width: 100%;">
    <thead >
    <tr>
        <th colspan="2"><h2>MENU</h2></th>
        <th colspan="2"><h2>MAIN</h2></th>
        <th colspan="2"><h2>CONTACTS</h2></th>
    </tr>
    </thead>


    <tbody width="100%">
    <tr  width="100%">
        <td colspan="6"><center> <h3>Здесь может быть Ваша реклама </h3> </center> <br/>
            <%! int count = 0;%>

            <%
                out.print("Колличество посещений: " + count);
                ++count;
            %>

        </td>
    </tr>
    <tr >
        <td width="16%"></td>
        <td width="16%"></td>
        <td width="16%"></td>
        <td width="16%"></td>
        <td width="16%"></td>
        <td width="16%"></td>
    </tr>
    <tr>
        <td>3</td>
        <td>2</td>
    </tr>
    </tbody>
    <tfoot>

    </tfoot>
</table>
