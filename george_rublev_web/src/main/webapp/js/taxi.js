/**
 * Created by Well on 21.07.2015.
 */

var ajax = new XMLHttpRequest();
var login = document.getElementById("login");
var pass = document.getElementById("pass");
ajax.onreadystatechange = function () {
    if (ajax.readyState === 4 && ajax.status === 200) {
        if (ajax.responseText !== 'false') {
        var div = document.getElementById('resp');
            div.innerHTML = ajax.responseText;//ajax.responseText.split('|');


        } else {
            alert('Login or Password - FAILED!!!!');
        }
    }
    ;

    function check() {
        ajax.open('GET', '/ajax?login=' + login.value + '&pass=' + pass.value);
        ajax.send();
    }

}