/**
 * Created by ПК on 29.07.2015.
 */
// RAZERtest   3224018999  NwRAZER887766




/*$(document).ready(function(){
    var dashBatton = $("#dashButton")
    dashBatton.hide();


});*/



    function check() {

        var loginS = $("#login").val();
        var innS = $("#inn").val();
        var passwordS = $("#password").val();
        var passordConfirmS = $("#passwordConfirm").val();
        var info = $("#info");


        var passIsValid = false;
        var passContainsLowerCase = false;
        var passContainsUpperCase = false;
        var passContainsDigit = false;
        //alert("login: " + loginS + ", inn: " + innS + ", password: " + passwordS+ ", pass Confirm: " + passordConfirmS);

        //Login Check by length.
        if (loginS.length < 4) {
            alert(loginS.length)
            alert("Login too short!");
            //Login Check by Spaces.
        } else if (loginS.indexOf(" ") > -1) {
            alert("Login contains space!");
            //inn check
        } else if (innS.length < 10) {
            alert("INN too short!");
        }  else {
            for (var j = 0; j < innS.length; j++) {
                if (isNaN(parseInt(innS.charAt(j)))) {
                    alert("INN contains not only digits!");
                    break;
                }
            }
        }
             //Password check.
        if (!(passwordS == passordConfirmS)) {
        alert("Password not equals with confirm!");
        }
        if ((passwordS.length < 8)) {
            alert("Password too short");
        } else {
            for (var i = 0; i < passwordS.length; i++) {
                if (isNaN(parseInt(passwordS.charAt(i)))) {
                    passContainsDigit = true;
                }
                if ((passwordS.charAt(i)) === (passwordS.charAt(i)).toUpperCase()) {
                    passContainsUpperCase = true;
                }
                if ((passwordS.charAt(i)) === (passwordS.charAt(i)).toLowerCase()) {
                    passContainsLowerCase = true;
                }
                if (passContainsLowerCase & passContainsUpperCase & passContainsDigit) {
                    passIsValid = true;
                    break;
                }
            }
        }
        if (!passIsValid) {
            alert("Password is invalid!");
        } else
            $.ajax({
                url: "/registerOper",
                type: "POST",
                data:  {login: loginS, inn: innS, password: passwordS, passwordConfirm: passordConfirmS},
                dataType: "text",
                beforeSend: function(){
                    info.text("Sending data....")},
                success: function(jqXHR){
                    //sessionStorage.setItem("operlogin", loginS);
                    //$("#dashButton").show();
                   // alert("Success!!!");
                    info.text(jqXHR);
                }
            })
    }


