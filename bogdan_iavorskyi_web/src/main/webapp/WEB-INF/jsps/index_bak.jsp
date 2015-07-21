<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 06.07.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    int counter;
%>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
<table border="1" style="width:100%">
    <thead style="width:100%">
        <tr>
            <th colspan="2">1</th>
            <th colspan="2">1</th>
            <th colspan="2">1</th>
        </tr>
    </thead>
    <tbody style="width:100%">
    <tr>
        <td colspan="6">
            ${name}
        </td>
    </tr>
    <tr>
        <td>6</td>
        <td>6</td>
        <td>6</td>
        <td>6</td>
        <td>6</td>
        <td>6</td>
    </tr>
    <tr style="height: 200px">
        <td colspan="2">6</td>
        <td colspan="4">6</td>
    </tr>
    </tbody>
    <tfoot>
        <tr>
            <td colspan="6" bgcolor="gray">bogdanProduction. Counter:
            <%
                out.println(++counter);
            %>
            </td>
        </tr>
    </tfoot>
</table>
</body>
</html>
