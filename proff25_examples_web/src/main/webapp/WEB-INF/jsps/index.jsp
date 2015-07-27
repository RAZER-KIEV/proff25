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
    <script src="js/jquery-1.11.1.js"></script>
    <script src="js/script.js"></script>
</head>
<body>
<fieldset>
    <legend id="send">Регистрация</legend>
    Ваш логин:<input id="login" type="text" name="login" value="Sobaka"/><br/>
    <%--<input type="submit" value="Send"/>--%>
    <button onclick="send()">Send</button>
</fieldset>
</body>
</html>
