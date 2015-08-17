<%--
  Created by IntelliJ IDEA.
  User: Sveta
  Date: 8/11/2015
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>New Client</title>
</head>
<body background="image/taxi.jpg">
<center>

    <br>
    <br>
    <br>
  <form action="/createClient" method="post">
    <p style="color: gold">First Name: <input type="text" name="name" style="border-radius: 5px"/> </p>
    <p style="color: gold">Second Name: <input type="text" name="surname" style="border-radius: 5px"/>  </p>
    <p style="color: gold">Phone Number: <input type="text" name="phone" style="border-radius: 5px"/></p>
    <p style="color: gold">Address: <input type="text" name="adress" style="border-radius: 5px"> </p>
    <input type="submit" formaction="/index" name="createClient" value="Register!" style="border-radius: 5px"/>
    <button formaction="/dashboard"  type="submit" formmethod="post" name="PreviousPage" value="Previous Page!" style="border-radius: 5px">Previous Page!</button>
  </form>

</center>
</body>
</html>
