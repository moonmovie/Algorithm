let boardlist=[];
$(document).ready(function () {
	console.log($('#navul').children().length);
    $.ajax({
        type: "GET",
        url: "notice.jsp",
        dataType: "json",
        success: function (res) {
          
            boardlist = res.items;
            let tr;
            boardlist.forEach(ele => {
                tr+=
                `<tr id="listtr">
                <td>${ele.index}</td>
                <td>${ele.title}</td>
                <td>${ele.writer}</td>
                <td>${ele.views}</td>
                <td>${ele.date}</td>
                </tr>`;
            });
            $('tbody').append(tr);
        }
    });
    $(document).on('click', '#listtr',function () {
        let pk=$(this).children().get(0).textContent;
        window.location.assign(encodeURI('noticeRead.html?pk='+pk+'&l='+$('#navul').children().length));
    });
    $("#boardW").on('click', function () {
        console.log($('#navul').children().length);
        if($('#navul').children().length<5){
            alert("로그인을 먼저해주세요");
            return;
        }else{
            window.location.assign('writer.html');
        }
    	
    });
});