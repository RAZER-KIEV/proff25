<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User authentication</title>
    <%--<script src="js/jquery-1.11.1.js"></script>--%>
    <%--<script src="js/script.js"></script>--%>
</head>
<body>
<h1 align="center">User authentication</h1>

<table border="0" cellspacing="100" width="100%"  >
       <th align="center" >
          <form action="/dashboard.html" method="post">
              <p><strong>Login: </strong>
                  <input type="text" name="login"/> <br/></p>
              <p><strong>Password: </strong>
                  <input type="password" name="password"/> </p>
              <a href="register.html">Registration</a>
              <p><font color="red"> ${warning}</font> </p>
               <input type="submit" value="Log in"/>

           </form>
       </th>
</table>

</body>
</html>
