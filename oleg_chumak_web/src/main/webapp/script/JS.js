/**
 * Created by oleg on 20.07.15.
 */

var arr = [1,2,3,4,5,6,7];
//document.write(arr);
//swap(arr);
check()

function check()
{
    var text = document.getElementById('text')
    if ( document.getElementById('a').value === document.getElementById('b').value){
        text.innerHTML = '<p>da</p>';
    }
    else {
        text.innerHTML = '<p>net</p>';
    }
}
function swap(arr) {
    for (a = 0; a <= arr.length / 2; a++) {
        b = arr[a];
        arr[a] = arr[arr.length - a - 1];
        arr[arr.length - a - 1] = b;
    }
    //document.write(arr);

    function auth(){
        if (document.getElementById('login').value === document.getElementById('password').value){
            return true;
        }
        else return false;
    }
}
