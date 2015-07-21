/**
 * Created by Well on 21.07.2015.
 */

var ajax = new XMLHttpRequest();

ajax.onreadystatechange = function () {
    if (ajax.readyState === 4 && ajax.status === 200) {
        if (ajax.responseText !== 'false') {
            //var div = document.getElementById('resp');
            //div.innerHTML = ajax.responseText;//ajax.responseText.split('|');
            document.write(ajax.responseText);
            resp.innerHTML=ajax.responseText;

        } else {
            alert('Login or Password - FAILED!!!!');
        }
    }
};


    function check() {
        var login = document.getElementById("login").value;
        var pass = document.getElementById("pass").value;
        console.log('/indexTaxi.html?login=' + login + '&pass=' + pass);
        ajax.open('GET', '/indexTaxi.html?login=' + login + '&pass=' + pass);
        ajax.send();
    }

