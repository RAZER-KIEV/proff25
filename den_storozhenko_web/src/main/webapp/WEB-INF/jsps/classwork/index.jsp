<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<table border="1px" width="100%" height="100%">
    <thead>
    <tr>
        <th width="33%" height="15%" colspan="2">Раздел1</th>
        <th width="33%" height="15%" colspan="2">Раздел2</th>
        <th width="33%" height="15%" colspan="2">Раздел3</th>
    </tr>
    </thead>
    <tbody>
        <tr><td colspan="6"; height="10%" width="100%"/></tr>

        <tr>
            <td width="16%" height="10%"><a href="/serv"/>vk1</td>
            <td width="16%" height="10%"><a href="http://vk.com"/>vk2</td>
            <td width="16%" height="10%"><a href="http://vk.com"/>vk3</td>
            <td width="16%" height="10%"><a href="http://vk.com"/>vk4</td>
            <td width="16%" height="10%"><a href="http://vk.com"/>vk5</td>
            <td width="16%" height="10%"><a href="http://vk.com"/>vk6</td>
        </tr>

        <tr>
            <td colspan="2" height="60%" width="33">
                <ul>
                    <li>list1</li>
                    <li>list2</li>
                    <li>list3</li>
                    <li>list4</li>
                    <li>list5</li>
                </ul>
            </td>
            <td colspan="4" height="60%" width="66">
                <img src="https://www.google.com.ua/images/srpr/logo11w.png" align="left" />
                <p>SADJFASJDD FAJSDJ FAJSD FJASJF<br/> AJSDF JAJKE WKAKSKASMM AMFD<br/> MASDFM ASM FASDF AF A FA DF</p>
            </td>
        </tr>
    </tbody>

    <tfoot>
        <tr>
            <td width="15%" height="5%">
                <%! int k=0;
                %>
                <%
                    k++;
                    out.println("Количество посещений: "+k);
                %>
                ${name}
            </td>
            <td width="15%" height="5%">
                <form action="/great.html" method="POST">
                    <input type="text" name="login" value="YourName"/>
                    <input type="password" name="password" value="YourPass"/>
                    <input type="submit" value="SEND" align="center"/>
                </form>
            </td>
            <td width="60%" colspan="5" height="5%">
                <p align="right">
                    (c)Denst
                </p>
            </td>
        </tr>
    </tfoot>
</table>
</body>
</html>
