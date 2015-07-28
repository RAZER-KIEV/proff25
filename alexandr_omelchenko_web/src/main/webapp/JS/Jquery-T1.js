
$(document).ready(function(){
  //  $('#t1').hide();

    var el1=$('#t1');
    var el2=$('#t2');
    var el3=$('#t3');
    var body=$('#bod');

    el1.css('color', 'red');
    el2.css({border: '1px solid red'} );
    el2.css('fontWeight', 'bold');
    el3.css('fontWeight', 'bold');
    body.append($('<div>Text4</div>'));

});