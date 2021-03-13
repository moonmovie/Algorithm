$(document).ready(function () {
    $('.btnwt').on('click', function () {
        
        if($('.navbar-nav').children().lenght>2){
            alert("로그인을 먼저 해주세요");
            return;
        }

        if($('#title').val()!=null&&$('#content').val()!=null){
            $.ajax({
                type: "POST",
                url: "url",
                data: $(".formwt").serialize(),
                success: function (res) {
                    if(res!="0"){
                        alert("success")
                    }
                }
            });
        }else{
            alert("내용을 다 작성해 주세요");
        }
       
    });
});