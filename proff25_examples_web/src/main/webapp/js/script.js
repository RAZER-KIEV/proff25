/**
 * Created by al1 on 7/8/15.
 */
$(document).ready(function () {
    $.ajax({
        url: '/ajax',
        success: function (res) {
            alert(res);
        },
        error: function (a, b, c) {
            alert(a + b + c);
        }
    });
});