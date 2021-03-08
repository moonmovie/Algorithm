let cal = "";
let flag = false;
let temp="";
let result="";
$(document).ready(function () {

  $(".number").on("click", function () {
    flag = false;
    $("#numarea").val("");
    if (!cal) {
      if ($(this).html() == "0") {
        return;
      }
    }
    cal += $(this).html();
    temp+=$(this).html();
    console.log(cal);
    $("#numarea").val(temp);
  });

  $(".cal").on("click", function () {
    if (!flag) {
      flag = true;
      cal += $(this).html();
      temp="";
      console.log(cal);
    }
  });

  $("#equals").on("click", function () {
    if(!flag){
        let resultsentance = cal;
        resultsentance += `=${eval(cal)}`;
        flag = false;
        $("#numarea").val(eval(cal));
        result+=`<div class="log">${resultsentance}</div>`;
        $('.result').html(result);
        console.log(eval(cal));
        console.log(resultsentance);
        cal = "";
        temp="";
    }
  });
  $(".clear").on("click", function () {
    cal = "";
    flag = false;
    temp="";
    $("#numarea").val("");
  });
});
