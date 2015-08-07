/*var val=[1,2,3,4,5,6,7,8];

for (var i=0;i<val.length/2; i++){
    var temp = val[i];
    val[i] = val[val.length-i-1];
    val[val.length-i-1] = temp;
}
for (var i=0;i<val.length; i++){
    document.write(val[i]+' ');
}*/

function ku(int) {
    document.write('KU!');
    document.write(int);
    return 1;
}
document.write(typeof ku());
document.write(ku(2));