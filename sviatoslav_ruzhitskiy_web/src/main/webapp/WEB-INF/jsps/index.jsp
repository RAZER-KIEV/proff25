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

<%! int count=0; %>

<%
    if(request.getAttribute("countAdd")!=null){
  count+= (int)request.getAttribute("countAdd");}
%>
Logining retry: <%=count%>
<form id="regForm1" action="/register" method="post">
  <input type="submit" name="register" value="Registeration">
</form>
</body>
<script src="js/script.js">
</script>
<span id="spn">
<p id="myP">No</p>
<p><input type="text" name="text1" /></p>
<p><input type="text" name="text2" /></p>
<button onclick="check">Check</button></p>
</span>

<script src="js/script.js">
    </script>
</html>
<center>
  <h2 style="color:white">Authentication!</h2>
  <form name ="myAuthForm" action="/auth" method="post">
   <table border="0" cellspacing="5" cellpadding="5">
      <tr>
        <td align="right" valign="top" style="color:white">Enter login</td>
        <td><input type="text" name="login" size="25"
                   maxlength="15"><br></td>
      </tr>
      <tr>
        <td align="right" valign="top" style="color:white">Enter password</td>
        <td><input type="password" name="password" size="25"
                   maxlength="15" value="password"><br></td>
      </tr>
      <tr>
        <td><input type="submit" name="submit" value="Login">
        </td>
     </tr>
    </table>
  </form>
</center>
</body>

