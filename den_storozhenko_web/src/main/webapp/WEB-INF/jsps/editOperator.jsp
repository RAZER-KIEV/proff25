<%@ page import="hw8.taxi.domain.Operator" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit operator</title>
    <link rel="stylesheet" href="css/operatorEdit.css"/>
    <script>
        var req = new XMLHttpRequest();
        req.onreadystatechange = function(){
            if (req.readyState==4 && req.status==200){
                if (req.responseText==="edited"){
                    document.getElementById("span").innerHTML = '<span><font color="BLUE">'+"Operator was edited."+'</font></span>'
                }
                else{
                    document.getElementById("span").innerHTML = '<span><font color="RED">'+req.responseText+'</font></span>'

                }
            }
        };
        function editOperator(){
            var login = document.getElementById('login').value;
            var newLogin = document.getElementById('newLogin').value;
            var password = document.getElementById('password').value;
            var newRole = document.getElementById('newRole').value;
            var ident = document.getElementById('ident').value;
            var countAttempts = document.getElementById('countAttempts').value;
            var isBlocked = document.getElementById('isBlocked').value;
            req.open("POST",'/submitEditOperator',true);
            req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
            req.send('login='+login+'&newLogin='+newLogin+'&password='+password+'&newRole='+newRole+'&ident='
                +ident+'&countAttempts='+countAttempts+'&isBlocked='+isBlocked);
        }
        </script>
</head>
<body>
<div id="wrapper" class="login-form">
    <div class="header">
        <h1>Operator editing</h1>
        <span id="span"></span>
    </div>

    <div class="content">
        <table>
            <tr>
        <td>Operator:</td>
                <td><select id="login" class="input password">
            <% List<Operator> operators = (List<Operator>)request.getAttribute("operators");
                if (operators!=null)
                    for(Operator o:operators){
            %>
            <option value="<%=o.getLogin()%>"><%=o.getLogin() %></option>
            <%} %>
        </select><br></td>
                </tr>
            <tr><td>New login:</td><td> <input type="text" class="input password" id="newLogin" placeholder="Login"/><br></td></tr>
            <tr><td>New password:</td> <td><input type="text" class="input password" id="password" placeholder="Password"/><br></td></tr>
            <tr><td>New role:</td><td> <select id="newRole" class="input password">
        <% List<String> roles = (List<String>)request.getAttribute("roles");
            if (roles!=null)
                for(String s:roles){
        %>
        <option value="<%=s%>"><%=s %></option>
        <%} %>
        </select><br></td></tr>
            <tr><td>New ID:</td><td> <input type="text" class="input password" id="ident" placeholder="Id"/><br></td></tr>
        <%-- <input type="checkbox" name="params[]" value = "clearAttempts"/>Clear attempts to enter wrong password<br>
         <input type="checkbox" name="params[]" value="unblock"/>Unblock operator<br>--%>
            <tr><td>Count attempts to enter wrong password:</td><td> <input class="input password" type="number" id="countAttempts" placeholder="Count attempts"/><br></td></tr>
            <tr><td>Is blocked:</td><td> <select class="input password" id="isBlocked">
        <option value="false">false</option>
        <option value="true">true</option>
    </select><br></td>
            </tr>
        </table>
    </div>
    <div class="footer">
        <input type="button" class="button" value="Edit operator" onclick="editOperator()"/>
        <input type="button" name="back" value="Back" class="register" onclick="location.href='/'" /><br>
        <font size="2px" color="RED">*Leave blank to remain the same data.</font>
    </div>
  <%--<input type="submit" value="Edit operator"/>--%>
<%--<a href="/dashboard.html">Back</a>--%>
<%--<form action="/logout" method="GET">--%>
  <%--<input type="submit" value="Log out"/>--%>
<%--</form>--%>
</div>
</body>
</html>
