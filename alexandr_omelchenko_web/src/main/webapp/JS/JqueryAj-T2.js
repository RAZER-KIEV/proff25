
$(document).ready(function(){
    $.ajax({

        url:'/ajax',
        success: function(res){
        },
        error: function(p1,p2,p3){
            alert(p1+p2+p3);
        },

    });



});
