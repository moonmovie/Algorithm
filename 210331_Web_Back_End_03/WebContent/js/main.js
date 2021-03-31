

$(document).ready(function () {
	
    $('#loginbtn').on("click",()=>{
       if($('#userid').val()!=null && $('#userpwd').val()!=null){
           $('#loginform').attr('action',root+'/main?act=login').submit();
       }
    });
});