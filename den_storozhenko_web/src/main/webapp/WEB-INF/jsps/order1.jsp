<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New order</title>
    <link rel="stylesheet" href="css/index.css">
    <script>
      var req = new XMLHttpRequest();
      req.onreadystatechange = function(){
        if (req.readyState==4 && req.status==200){
          if (req.responseText==="created"){
            location.reload();
            document.getElementById('spanCreate').innerHTML = '<span><font color="BLUE">'+"Order was created."+'</font></span>';
          }
          else if(req.responseText==="edited"){
            location.reload();
            document.getElementById('spanEdit').innerHTML = '<span><font color="BLUE">'+"Order was edited."+'</font></span>';
          }
          else if(req.responseText==="Ncreated"){
            document.getElementById('spanCreate').innerHTML = '<span><font color="RED">'+"Order was created."+'</font></span>';
          }
          else if(req.responseText==="Nedited"){
            document.getElementById('spanEdit').innerHTML = '<span><font color="RED">'+"Order was edited."+'</font></span>';
          }
          else if(req.responseText.charAt(0)==="C"){
            document.getElementById('spanCreate').innerHTML = '<span><font color="RED">'+req.responseText.substr(1,req.responseText.length)+'</font></span>';
          }
          else if(req.responseText.charAt(0)==="E"){
            document.getElementById('spanEdit').innerHTML = '<span><font color="RED">'+req.responseText.substr(1,req.responseText.length)+'</font></span>';
          }

        }
      };
      function createOrder(){
        var phone = document.getElementById('phone1').value;
        var amount = document.getElementById('amount1').value;
        var from = document.getElementById('from1').value;
        var to = document.getElementById('to1').value;
        req.open("POST",'/create',true);
        req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
        req.send('phone='+phone+'&amount='+amount+'&from='+from+'&to='+to);
      }
      function editOrder(){
        var id = document.getElementById('id').value;
        var phone = document.getElementById('phone2').value;
        var amount = document.getElementById('amount2').value;
        var from = document.getElementById('from2').value;
        var to = document.getElementById('to2').value;
        req.open("POST",'/edit',true);
        req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
        req.send('id='+id+'&phone='+phone+'&amount='+amount+'&from='+from+'&to='+to);
      }
    </script>
</head>
<body>
<table  width="100%" >
  <tr>
    <td width="50%" height="100%">
      <div id="wrapper" class="login-form">
      <div class="header">
        <h1>Create Order</h1>
        <span id="spanCreate"></span>
      </div>
      <div class="content">
        Client:<br> <select id="phone1" class="input password">
        <% List<String> names = (List<String>)request.getAttribute("phones");
          if (names!=null)
            for(String s:names){
        %>

        <option value="<%=s %>"><%=s %></option>
        <%} %>

      </select>
        <input type="text" id="amount1" class="input password" placeholder="Amount"/>
        <input type="text" id="from1" class="input password" placeholder="Address from"/>
        <input type="text" id="to1" class="input password" placeholder="Address to"/>
      </div>
      <div class="footer">
        <input type="button" class="button" value="Create" onclick="createOrder()"/>
        <input type="button" name="back" value="Back" class="register" onclick="location.href='/'" />
      </div>
    </div>
    </td>
    <td width="50%">
      <div id="wrapper1" class="login-form">
        <div class="header">
          <h1>Edit Order</h1>
          <span id="spanEdit"></span>
        </div>
        <div class="content">
          Order:<br> <select id="id" class="input password">
            <% List<String> ids = (List<String>)request.getAttribute("ids");
      if (ids!=null)
        for(String s:ids){
        %>
          <option value="<%=s %>"><%=s %></option>
            <%} %>
        </select>
          <br>Client:<br> <select id="phone2" class="input password">
          <%
            if (names!=null)
              for(String s:names){
          %>
          <option value="<%=s %>"><%=s %></option>
          <% } %>
        </select>
          <input type="text" id="amount2" class="input password" placeholder="Amount"/>
          <input type="text" id="from2" class="input password" placeholder="Address from"/>
          <input type="text" id="to2" class="input password" placeholder="Address to"/>
        </div>
        <div class="footer">
          <input type="button" class="button" value="Edit" onclick="editOrder()"/>
          <input type="button" name="back" value="Back" class="register" onclick="location.href='/'" />
        </div>
      </div>
    </td>
  </tr>
</table>
</body>
</html>
