
let userlist=[];
$(document).ready(function () {
  $(".btn.btn-primary.btn-block.submitbtn").on("click", function () {
    if($('.validbtn').text()!="Vaild"){
        alert("Please check ID");
    }else{
        $('#Modallogin').modal("show");
        
        $.ajax({
          type: "GET",
          url: "userxml.jsp",
          data: $("form").serialize(),
          success: function (res) {
              if(res=='success'){
                $('#Modallogin').modal("show");
              }
          },
        });
        
        $('.formdiv').css("display","none"); 
    }
   


  });
  $(".signup").on("click", function () {
    $('.formdiv').css("display","");  
    $.ajax({
      type: "GET",
      url: "userxml.jsp",
      dataType: "xml",
      success: function (res) {
        $(res)
          .find("user")
          .each(function (index, item) {
            userlist.push($(this).find("id").text());
          });
      },
    });
  });

  $("#uid").keyup(function (e) { 
    // let idstr = $('#uid').val();
    // console.log(idstr);
    $('.validbtn').text("Valid Check");
    $('.validbtn').attr("class","btn btn-primary mt-2 validbtn");
    // userlist.forEach((element) => {
    //   if (element == idstr) {
    //     $('#idinvalid').css("display","");
    //     $('#idvalid').css("display","none");
    //     console.log(idstr+","+element);
        
    //   } else {
    //     $('#idinvalid').css("display","none");
    //     $('#idvalid').css("display","");
    //   }
    // });
  });

 $('.validbtn').on('click', function(){
    let flag=false;
    let idstr = $('#uid').val();
    var idRegExp = /^[a-zA-Z0-9]{5,12}$/;
    if(!idRegExp.test(idstr)){
        $('.validbtn').text("Over the 4 chracters Alphabet and Numbers");
        $('.validbtn').attr("class","btn btn-success mt-2 validbtn");
        return;
    }
    
    userlist.forEach(element => {
        if (element == idstr) {    
            console.log(element);    
           flag=true;
        }
    });
    
    if(!flag){
        $('.validbtn').text("Vaild");
        $('.validbtn').attr("class","btn btn-success mt-2 validbtn");
    }else{
        $('.validbtn').text("Invaild");
        $('.validbtn').attr("class","btn btn btn-danger mt-2 validbtn");
    }
 });
  $(".login").on("click", function () {
    $('.formdiv').css("display","none");
    let id = $("#loginid").val();
    let pw = $("#loginpwd").val();
    let flag=false;
    $.ajax({
      type: "GET",
      url: "userxml.jsp",
      dataType: "xml",
      success: function (res) {
        $(res)
          .find("user")
          .each(function (index, item) {
            if ($(this).find("id").text() == id) {
              if ($(this).find("password").text() == pw) {
                $(".nav-item").css("display", "none");
                var li = $(
                  `<li class="nav-item">
                               <a class="nav-link mypage" href="javascript:void(0)">Mypage</a>
                             </li>
                             <li class="nav-item">
					            <a class="nav-link logout" href="javascript:void(0)">Logout</a>
				            </li>`
                );

                $(".navbar-nav").append(li);
                $('#nouser').css("display","none");   
                $('#myModal').modal("close");
                 
                flag=true;
              }
            }
          });

          if(!flag){
            $('#myModal').modal("show");
            $('#nouser').css("display","");  
        }
      },
    });
  });

  $(document).on("click", ".logout", function () {
    $('.formdiv').css("display","none");
    $(".mypage").parent().remove();
    $(".logout").parent().remove();
    $(".nav-item").css("display", "");
  });
});
