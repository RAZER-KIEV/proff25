<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New order</title>
  <link rel="stylesheet" href="css/index.css">
</head>
<body>
<span>
  <font color="BLUE">${info}</font>
 <font color="RED">${orderEx}</font>
</span>
<table  width="100%" >
  <tr>
    <td width="50%" height="100%">
      <form name="login-form" class="login-form" action="/create1" method="GET">
      <div class="header">
        <h1>Create Order</h1>
      </div>
      <div class="content">
        Client:<br> <select name="names" class="input password">
        <% List<String> names = (List<String>)request.getAttribute("names");
          if (names!=null)
            for(String s:names){
        %>

        <option value="<%=s %>"><%=s %></option>
        <%} %>

      </select>

        <input type="text" name="amount" class="input password" placeholder="Amount"/>
        <input type="text" name="from" class="input password" placeholder="Address from"/>
        <input type="text" name="to" class="input password" placeholder="Address to"/>
      </div>
      <div class="footer">
        <input type="submit" class="button" value="Create "/>
        <input type="button" name="back" value="Back" class="register" onclick="location.href='/'" />
      </div>
    </form>
    </td>
    <td width="50%">
      <form class="login-form" action="/edit1" method="GET">
        <div class="header">
          <h1>Edit Order</h1>
        </div>
        <div class="content">
          Order:<br> <select name="id" class="input password">
            <% List<String> ids = (List<String>)request.getAttribute("ids");
      if (ids!=null)
        for(String s:ids){
        %>
          <option value="<%=s %>"><%=s %></option>
            <%} %>
        </select>
          <br>Client:<br> <select name="names1" class="input password">
          <%
            if (names!=null)
              for(String s:names){
          %>
          <option value="<%=s %>"><%=s %></option>
          <% } %>
        </select>
          <input type="text" name="amount1" class="input password" placeholder="Amount"/>
          <input type="text" name="from1" class="input password" placeholder="Address from"/>
          <input type="text" name="to1" class="input password" placeholder="Address to"/>
        </div>
        <div class="footer">
          <input type="submit" class="button" value="Edit order"/>
          <input type="button" name="back" value="Back" class="register" onclick="location.href='/'" />
        </div>
      </form>
    </td>
  </tr>
</table>
</body>
</html>
