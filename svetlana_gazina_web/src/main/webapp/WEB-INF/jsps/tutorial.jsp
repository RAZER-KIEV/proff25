<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.util.Calendar" %>
<%--
  Created by IntelliJ IDEA.
  User: Sveta
  Date: 8/10/2015
  Time: 8:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<center>
  <h2>Auto Refresh Header Example</h2>
  <%
    // Set refresh, autoload time as 5 seconds
    response.setIntHeader("Refresh", 1);
    // Get current time
    Calendar calendar = new GregorianCalendar();
    String am_pm;
    int hour = calendar.get(Calendar.HOUR);
    int minute = calendar.get(Calendar.MINUTE);
    int second = calendar.get(Calendar.SECOND);
    if(calendar.get(Calendar.AM_PM) == 0)
      am_pm = "AM";
    else
      am_pm = "PM";
    String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
    out.println("Current Time is: " + CT + "\n");
  %>
</center>
<center>
  <h2>HTTP Header Request Example</h2>
  <table width="100%" border="1" align="center">
    <tr bgcolor="#949494">
      <th>Header Name</th><th>Header Value(s)</th>
    </tr>
    <%
      Enumeration headerNames = request.getHeaderNames();
      while(headerNames.hasMoreElements()) {
        String paramName = (String)headerNames.nextElement();
        out.print("<tr><td>" + paramName + "</td>\n");
        String paramValue = request.getHeader(paramName);
        out.println("<td> " + paramValue + "</td></tr>\n");
      }
    %>
  </table>
</center>
<%@ include file="header.jsp" %>
<center>
  <p>Thanks for visiting my page.</p>
</center>
<%@ include file="footer.jsp" %>

<center>
  <h2>The include action Example</h2>
  <jsp:include page="date.jsp" flush="true" />
</center>

<center>
  <h2>Using JavaBeans in JSP</h2>

  <jsp:useBean id="test" class="action.TestBean" />

  <jsp:setProperty name="test"
                   property="message"
                   value="Hello JSP..." />

  <p>Got message....</p>

  <jsp:getProperty name="test" property="message" />

</center>

<center>
  <h2>The forward action Example</h2>
  <jsp:forward page="date.jsp" />
</center>

1
</body>
</html>
