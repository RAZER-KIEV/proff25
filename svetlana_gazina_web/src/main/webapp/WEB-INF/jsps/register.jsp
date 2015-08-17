<%--
  Created by IntelliJ IDEA.
  User: Sveta
  Date: 8/10/2015
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Yellow Cab</title>

</head>
<body background="image/taxi.jpg">
<form draggable="true">
    <label style="color: gold">Enter your name: </label><br/>
    <input id="login" type="text" name="login" value="Name..." style="border-radius: 10px" onclick="this.value=''"/><br/>
    <label style="color: gold">Enter your ID: </label><br/>
    <input input id="inn" type="text" name="inn"  value="ID..." style="border-radius: 10px" onclick="this.value=''"/><br/>
    <label style="color: gold">Enter your password: </label><br/>
    <input input id="password" type="password" name="password"  value="Password..." style="border-radius: 10px" onclick="this.value=''"/><br/>
    <label style="color: gold">Confirm your password: </label><br/>
    <input id="passwordConfirm" type="password" name="passwordConfirm"  value="Password..." style="border-radius: 10px" onclick="this.value=''"/><br/><br/>
    <input id="authenticateButton" formaction="/createEditOperator" formmethod="post" css="" type="submit" value="register" style="border-radius: 5px" align="right"/>
</form>
</body>
</html>
