var val = '33';
//console.log(val);
//document.write('Hello');
function print(){
    document.write('Hello JS');
}
//print();
//equals();
function equals() {
    var el =  document.getElementById('sr');
    if (document.getElementById('w1').value === document.getElementById('w2').value) {
        el.innerHTML = 'ДА';
    }
    else {
        el.innerHTML = 'НЕТ';
    }
}
function check() {
    var mess =  document.getElementById('mess');
    var log = document.getElementById('lgn');
    var pass = document.getElementById('pwd');
    var form = document.getElementById('frm');
    if (log.value !== pass.value && pass.value.length>6) {
        form.action ='/auth.html';
        form.method = 'GET';
        mess.innerHTML = 'Данные переданы на сервер';
    }
    else {
        mess.innerHTML = 'Введены некорректные данные';
    }
}