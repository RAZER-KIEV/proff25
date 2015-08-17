<%--
  Created by IntelliJ IDEA.
  User: Sveta
  Date: 8/7/2015
  Time: 12:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
  int pageCount = 0;
  void addCount() {
    pageCount++;
  }
%>
<% addCount(); %>
<html>
<head>
  <title>The include Directive Example</title>
</head>
<body>
<center>
  <h2>The include Directive Example</h2>
  <p>This site has been visited <%= pageCount %> times.</p>
</center>
<br/><br/>