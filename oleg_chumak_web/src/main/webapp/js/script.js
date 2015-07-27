/**
 * Created by oleg on 27.07.15.
 */
var req;
function init() {
    req = new XMLHttpRequest();
    req.onreadystatechange = function () {
        if (req.readyState == 4 && req.status == 200) {
            var table = req.responseText;
            var rows = table.split(',');
            document.getElementById('message').innerHTML = rows[0];
            if (rows.length > 1) {
                var resultingTable = '<table>';
                resultingTable+='<tr>';
                var column = rows[1].split('|');
                for (var j = 0; j < column.length; j++) {
                    resultingTable+='<th>' + column[j] + '</th>';
                }
                resultingTable+='</tr>';
                for (var i = 2; i < rows.length; i++) {
                    if (rows[i].length == 0) {
                        continue;
                    }
                    resultingTable+='<tr>';
                    var column = rows[i].split('|');
                    for (var j = 0; j < column.length; j++) {
                        resultingTable+='<td>' + column[j] + '</td>';
                    }
                    resultingTable+='</tr>';
                }
                resultingTable+='</table>';
                console.log(resultingTable);
                document.getElementById('tableField').innerHTML = resultingTable;
            }
        }
    };
}

function clients() {
    req.open('POST', '/ajaxClients', true);
    req.send();
}

function drivers() {
    req.open('POST', '/ajaxDrivers', true);
    req.send();
}

function orders() {
    req.open('POST', '/ajaxOrders', true);
    req.send();
}

function clientsPortioned() {
    req.open('POST', '/ajaxClientsPortioned?numberOfPortion=2', true);
    req.send();
}

function clientsAmount() {
    req.open('POST', '/ajaxClientsMonth', true);
    req.send();
}

function ordersPortioned() {
    req.open('POST', '/ajaxOrdersPortioned?numberOfPortion=1', true);
    req.send();
}

function ordersAmount() {
    var min = document.getElementById("orMin")
    var max = document.getElementById("orMax")
    req.open('POST', '/ajaxClientsMonth?amountFrom='+min+"&&amountTo="+max, true);
    req.send();
}

function clientsMonth() {
    var amount = document.getElementById("clAm");
    req.open('POST', '/ajaxClientsMonth?amount='+amount, true);
    req.send();
}
