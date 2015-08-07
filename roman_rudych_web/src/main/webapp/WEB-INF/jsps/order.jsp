<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 04.08.2015
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<table border="0" cellspacing="20" width="100%">
    ${addAction}
    ${additionId}
    <tr>
      <th align="right"><strong>Client phone number(0505554433): </strong></th>
      <th align="left"><input type="text" name="clientPhoneNum"/> </th>
    </tr>
    <tr>
      <th align="right"><strong>Sum of order: </strong></th>
      <th align="left"> <input type="text" name="sum"/> </th>
    </tr>
    <tr>
      <th align="right"><strong>Address from: </strong></th>
      <th align="left"><input type="text" name="addressFrom"/> </th>
    </tr>
      <tr>
        <th align="right"><strong>Address to: </strong></th>
        <th align="left"><input type="text" name="addressTo"/> </th>
      </tr>
    <tr align="center">
      <p><font color="red"> ${warning}</font> </p>
    </tr>
    <tr>
      <th align="right"></th>
      <th align="left"> <input type="submit" value="${buttonName}"/> </th>
    </tr>

  </form>

</table>
</body>
</html>
