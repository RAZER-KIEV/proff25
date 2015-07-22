/**
 * Created by bosyi on 20.07.15.
 */

/**
 * Created by bosyi on 21.07.15.
 */
var req;
function init() {
    req = new XMLHttpRequest();
    req.onreadystatechange = function () {
        if (req.readyState == 4 && req.status == 200) {
            if (req.responseText === '0') {
                document.getElementById('message').innerHTML = 'Bad login or password';
            } else {
                var table = req.responseText;
                var resultingTable = '<table>';
                var rows = table.split('*');
                for (var i = 0; i < rows.length; i++) {
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
                document.getElementById('loginField').style.display = 'none';
                document.getElementById('tableField').innerHTML = resultingTable;
            }
        }
    };
}

/*function init() {
    req = new XMLHttpRequest();
    req.onreadystatechange = function () {
        if (req.readyState == 4 && req.status == 200) {
            var response = req.responseText;
            if (response === '0') {
                document.getElementById('message').innerHTML = 'Bad login or password';
            } else {
                document.getElementById('loginField').style.display = 'none';
                document.getElementById('tableField').innerHTML = response;
            }
        }
    };
}*/

function sendTo() {
    console.log('inSendTo')
    var login = document.getElementById('login').value;
    var password = document.getElementById('password').value;
    req.open('POST', 'ajax?login='+login+'&&password='+password,true);
    req.send();
}
