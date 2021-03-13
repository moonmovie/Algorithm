
$(document).ready(function () {
    let urljson= getJsonURL();
    let pk = urljson.pk;
    let loginck = urljson.l;
    let  boardlist=[];
    $.ajax({
        type: "GET",
        url: "notice.jsp",
        dataType: "json",
        success: function (res) {
            // "items" : [{
            //     "index":"1",
            //     "title":"test",
            //     "writer":"작성자",
            //     "views":"100",
            //     "date":"2021-03-11",
            //     "contents":"test 내용입니다."
            // },
            boardlist = res.items;
            let contents;
            boardlist.forEach(ele => {
                if(ele.index==pk){
                    contents=
                    `
                        <div class="board_title"><h4>${ele.title}</h4></div>
                        <div class="board_info_box">
                            <span class="board_author">${ele.writer},</span><span class="board_date">${ele.date}</span>
                        </div>
                        <div class="board_content">${ele.contents}</div>
                    `
                }
            });
            $('#noticebody').append(contents);
        }
    });

    if(loginck==5){
        $(".nav-item").css("display", "none");
        var li = $(
          `<li class="nav-item">
                       <a class="nav-link mypage" href="javascript:void(0)">Mypage</a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link logout" href="index.html">Logout</a>
                    </li>`
        );

        $(".navbar-nav").append(li);
    }
    console.log(pk,loginck);
    console.log(boardlist);

});

function getJsonURL(){
    let query =location.search.substr(1);
    console.log(query);
    let result={};
    query.split("&").forEach(function(ele){
        let item = ele.split("=");
        result[item[0]]=decodeURIComponent(item[1]);
    });

    return result;
}