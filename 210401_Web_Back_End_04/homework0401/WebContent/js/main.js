

$(document).ready(function () {
	
    $('#loginbtn').on("click",()=>{
       if($('#userid').val()!=null && $('#userpwd').val()!=null){
           $('#loginform').attr('action',root+'/main?act=login').submit();
       }
    });

    $('#delete_btn').on("click",()=>{
        console.log("aa");
        $('#updatepro').attr('action','/homework0329/product?act=delete').submit();
        
     });
     $('#modify_btn').on("click",()=>{
        if($("#id").val()!=null&&$('#name').val()!=null && $('#price').val()!=null && $('#des').val()!=null){
            console.log("bb");
            $('#updatepro').attr('action','/homework0329/product?act=modify').submit();
        }
     });
});