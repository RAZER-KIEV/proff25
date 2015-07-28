/**
 * Created by george on 20.07.15.
 */



function func(){
    var val='33';
    console.log(val);
    var mas = [1,2,3,4,5,6,7,8,9,0];
    for(var i=mas.length-1; i>=0; i--){
        document.write(mas[i]);
    }
}

function butEquals(){
    var te1 = document.getElementById('t1').value;
    var te2 = document.getElementById('t2').value;
    var  te3 = document.getElementById('tUnsver');
    if(te1 === te2){
        te3.innerHTML="ДА";
    }else{
        te3.innerHTML="НЕТ";
    }

//return 'ДА';
}
var ajax = new XMLHttpRequest();
ajax.onreadystatechange = function () {
    if (ajax.readyState == 4 && ajax.status == 200) {
        var name = document.getElementById("send");
        name.innerHTML = ajax.responseText;
        alert(ajax.responseText);
    }
};

function send(arg) {
    var login = document.getElementById("login").value;
    ajax.open('GET', '/ajax?name=' + login);
    ajax.send();
}
