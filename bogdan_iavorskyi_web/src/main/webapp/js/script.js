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

            }
        }
    };
}

function sendTo() {
    console.log('inSendTo')
    var login = document.getElementById('login').value;
    var password = document.getElementById('password').value;
    req.open('POST', 'auth2?login='+login+'&&password='+password,true);
    req.send();
}
