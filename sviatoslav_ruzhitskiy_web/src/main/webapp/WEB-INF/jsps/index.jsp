<%--
  Created by IntelliJ IDEA.
  User: jax
  Date: 14.07.15
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
  <link href="/css/hw8CSS.css" rel="stylesheet"/>
</head>
<body>
<div class="wrapper">

<%! int count=0; %>

<%
    if(request.getAttribute("attempts")!=null){
  count+= (int)request.getAttribute("attempts");}
%>
Logining attempts: <%=count%>

  <form name ="myAuthForm" action="/auth" method="post">
    <fieldset id="indexFS">
        <legend>  Authentication!    </legend>
        <p>Login: <input id="login" type="text" name="login"/></p>
        <p>Password: <input id="password" type="password" name="password"/></p>
        <p><input type="submit" name="submit" value="Log in!">
            <button formaction="/register" formmethod="post">Registeration</button></p>

    </fieldset>
  </form>
</div>
</body>

