<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 06.07.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Task</title>
        <%--<script >--%>
            <%--var arr = [1,2,3,4,5,6];--%>
            <%--for (var i = arr.length - 1; i >= 0; i--) {--%>
                <%--console.log(arr[i]);--%>
                <%--document.write('Hello JavaScript =)) </br>');--%>


            <%--};--%>
        <%--</script>--%>
        <%--<script srs = "js/script.js"></script>--%>
        <script src="js/check.js"></script>
    </head>
    <body>

    <p> <input id="val1" maxlength="25" size="40" value=""></p>
    <p> <input id="val2" maxlength="25" size="40" value=""></p>
    <button onclick="check()">CHECK</button>




    <h2 onclick="print(234)">Hello PROFF :)) </h2>
    <table  style="width: 100%;">
        <thead >
            <tr>
                <th colspan="2"><h2>MENU</h2></th>
                <th colspan="2"><h2>MAIN</h2></th>
                <th colspan="2"><h2>CONTACTS</h2></th>
            </tr>
        </thead>

        <form action="/great.html" method="GET">
            <input type="text" name="login" value="Sidor" />
            < /br>
            <input type="submit" value="send" />
        </form>

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
