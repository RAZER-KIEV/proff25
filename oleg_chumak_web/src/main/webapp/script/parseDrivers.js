
var req;

function init() {
    req = new XMLHttpRequest();
    req.onreadystatechange = function () {
        if (req.readyState == 4 && req.status == 200) {
                var table = req.responseText;
                var resultingTable = '<table>';
                var rows = table.split(',');
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
                document.getElementById('drive').innerHTML = resultingTable;
        }
    };
}
function sendTo() {
    console.log('inSendTo');
    req.open('POST', 'ajaxDrivers?',true);
    req.send();
}