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
        console.log('check on');
        var ajax = new XMLHttpRequest();

        var login = document.getElementById("login").value;
        var pass = document.getElementById("pass").value;
        var resp = document.getElementById("resp").value;
        var dr =document.getElementsByName("dr").value;
        ajax.open('GET', '/indexTaxi.html?login=' + login + '&pass=' + pass);
        ajax.send();

        ajax.onreadystatechange = function () {
            if (ajax.readyState === 4 && ajax.status === 200) {
                if (ajax.responseText !== 'false') {
                    document.write(ajax.responseText);
                    resp.innerHTML=ajax.responseText;
                    //resp.innerHTML=document.getElementsByName();
                } else {
                    alert('Login or Password - FAILED!!!!');
                }
            }
        }


        //var login = document.getElementById("login").value;
        //var pass = document.getElementById("pass").value;
        console.log('/indexTaxi.html?login=' + login + '&pass=' + pass);
        //ajax.open('GET', '/indexTaxi.html?login=' + login + '&pass=' + pass);
        //ajax.send();
    }

var ajax = new XMLHttpRequest();
ajax.onreadystatechange = function () {
    if (ajax.readyState == 4 && ajax.status == 200) {

        var name = document.getElementById("resp");
        name.innerHTML = ajax.responseText;
        console.log(ajax.responseText);
    }
};

function send() {
    var login = document.getElementById("login").value;
    var pass = document.getElementById("pass").value;
    ajax.open('POST', '/indexTaxi.html?login=' + login+'&&pass='+pass,true);
    console.log('/indexTaxi.html?login='+login+'&&pass='+pass,true);
    ajax.send();
    if (ajax.readyState == 4 && ajax.status == 200) {
        var name = document.getElementById("resp");
        name.innerHTML = ajax.responseText;
        console.log(ajax.responseText);
    }
    if(ajax.status == 500){
        console.log(ajax.responseText);
    }
}