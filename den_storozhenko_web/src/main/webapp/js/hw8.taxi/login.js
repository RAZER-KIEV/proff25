$(document).ready(function(){
    $('#button').bind('click',function(){
        $.ajax({
                url: '/showFreeOrders',
                type: "GET",
                data: {phone: $('#login').val(), password: $('#password').val()},
                success: function (res) {
                    if (res.length==0){
                        $('#info').append('<font id="info" color="RED">'+"Phone and password incorrect. Try again."+'</font>');
                    }
                    else{

                        var result = $('<select id="order"></select>');
                        for(var i=0;i<res.length;i++){
                            result.append($('<option><font color="YELLOW">'+res[i].amount+'||'+res[i].addressFrom+'||'+res[i].addressTo+'||'+res[i].id+'</font></option>'));
                        }
                        $('#caption').hide();
                        $('#header').append($('<h1>Take order</h1>'))
                        $('#login').hide();
                        $('#password').hide();
                        $('#content').append(result);
                        $('#button').hide();
                        $('#footer').append($('<button id="take" class="button">TAKE ORDER</button>'));
                    }
                }
            }
        )
    });

    $('#take').bind('click',function(){
        $.ajax({
                url: '/takeOrder',
                type: "GET",
                data: {order: $('#order').val()},
                success: function (res) {
                    if (res==="-"){
                        $('#info').append('<font id="info" color="RED">'+"Order taking error. Try again."+'</font>');
                    }
                    else{
                        $('#info').append('<font id="info" color="BLUE">'+"Success!"+'</font>');

                    }
                }
            }
        )
    });
});
//$(document).ready(function(){
//    $('#button').bind('click',function(){
//        $.ajax({
//                url: '/tryDriverLogin',
//                type: "GET",
//                data: {phone: $('#login').val(), password: $('#password').val()},
//                success: function (res) {
//                    if (res==="error"){
//                        $('#info').append('<font id="info" color="RED">'+"Phone and password incorrect. Try again."+'</font>');
//                    }
//                    else{
//                        location.href = '/takeOrder.html';
//                    }
//                }
//            }
//        )
//    });
//});