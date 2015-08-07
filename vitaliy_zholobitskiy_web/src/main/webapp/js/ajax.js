/**
 * Created by al1 on 7/8/15.
 */
$(document).ready(function () {
    $.ajax({
        url: '/employee',
        success: function (res) {
            alert('res=' + res);
        },
        error: function (a, b, c) {
            alert(a);
        }
    })


});
var vector = [2, 4, 6, 3];
for (var i = 0; i < vector.length; i++) {
    var sum = 0;
    if (i - 1 >= 0) {
        sum += vector[i - 1];
    }
    if (i + 1 < vector.length) {
        sum += vector[i + 1];
    }
    vector[i] = sum;
}
//console.log(val);

function print() {
    //document.write(vector + '<br/>');
    alert(document.getElementById('login').value);
    return 'Это результат';
}

var res = print();
print();
document.write(res);
