<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 24.06.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
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
<body>
<c:out value="${name}"/>
<%--<form action="/great.html" method="GET">--%>
<fieldset>
    <legend id="send">Регистрация</legend>
    Ваш логин:<input id="login" type="text" name="login" value="Sobaka"/><br/>
    <%--<input type="submit" value="Send"/>--%>
    <button onclick="send()">Send</button>
</fieldset>
<%--</form>--%>
<!-- uygdfulhijghk'lkhjg -->
<%-- SECRET --%>
<%!
    public void doOutside() {
        System.out.println();
    }
%>

<%
    out.println("wert");
%>

<%= new java.util.Date() %>
<p>Полный а</p>
${name}
simple text <br/>
simple text <br/>
<a href="index2.jsp">Link</a>
<%--<img src="duke.running.gif"/>--%>
<q>Citata</q>
<ul>
    <li>One</li>
    <li>Two</li>
    <li>Three</li>
</ul>

<ol>
    <li>One</li>
    <li>Two</li>
    <li>Three</li>
</ol>

<table border="1">
    <thead>
    <tr>
        <th>First</th>
        <th>First</th>
        <th>First</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td rowspan="2">1</td>
        <td colspan="2">2</td>
    </tr>
    <tr>
        <td>2</td>
        <td>3</td>
    </tr>
    </tbody>
    <tfoot>

    </tfoot>
</table>
</body>
</html>
