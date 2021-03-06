
const root = "";

$(document).ready(function () {
    
    startLoadAjax(1);

    document.getElementById("list_btn").addEventListener("click",()=>{
        let product = document.getElementById("product");
        product.style.display="";
   
        product.innerHTML =
        `
        <form id="regist">
            <div class="form-group">
            <label for="id">상품번호:</label>
            <input type="text" class="form-control" id="pid" placeholder="상품번호" name="pid">
            </div>
            <div class="form-group">
            <label for="name">상품명:</label>
            <input type="text" class="form-control" id="pname" placeholder="상품명" name="pname">
            </div>
            <div class="form-group">
            <label for="price">가격:</label>
            <input type="text" class="form-control" id="price" placeholder="가격" name="price">
            </div>
            
            <div class="form-group">
            <label for="des">설명:</label>
            <input type="text" class="form-control" id="des" placeholder="설명" name="des">
            </div>
        </form>
        <button type="button" id="registe_btn" class="btn btn-primary">상품등록</button>
        `; 
        
        document.getElementById("registe_btn").addEventListener("click",()=>{
            
            let form = document.getElementById("regist");
            console.log(formTojson(form));
            
            $.ajax({
                type: "POST",
                url: root+"/product/change",
                headers:{
                    "Content-Type":"application/json"
                },
                data: JSON.stringify(formTojson(form)),
                dataType: "json",
                success: function (res) {
                    if(res>=1){
                       document.getElementById("regist").reset();
                       startLoadAjax(1);
                    }else{
                        alert("다시 시도해주세요");
                    }
                }
            });
        });
    });

    
});

function formTojson(formele) {
	let formdata = new FormData(formele);
    let jsonObj ={};

    for(const [key, value] of formdata.entries()){
        jsonObj[key]=value;
    }
    return jsonObj;
}

function startLoadAjax(page){
    let table = document.getElementById("listtable");
    table.innerHTM="";
    let innerhtml = "";
    $.ajax({
        type: "GET",
        url: root+"/product/list/"+page,
              
        success: function (res) {
        	
            if(res!=""||res!=null){
                innerhtml+=
                `
                <thead>
                     <tr>
                         <th>번호</th>
                         <th>상품번호</th>
                         <th>상품이름</th>
                         <th>가격</th>
                         <th>설명</th>
                     </tr>
                 </thead>`;
                 let idx = (page-1)*res.perpage;
                 res.list.forEach(ele => {
                    
                     innerhtml+=
                     `
                     <tr pid="${ele.pid }">
                         <td>${++idx}</td>
                         <td>${ele.pid }</td>
                         <td>${ele.pname }</td>
                         <td>${ele.price }</td>
                         <td>${ele.des }</td>
                     </tr>
                     `;
                     
                 });
               
            }else{
                innerhtml+=
                `
                <tr>
                    <td>해당상품이 없습니다.</td>
                </tr>
                `;
            }
            table.innerHTML=innerhtml;
            let tr = document.getElementsByTagName("tr");
            for(let i=0;i<tr.length;i++){
                tr[i].addEventListener("click",()=>{
                    console.log(tr[i].getAttribute("pid"));
                   trAjax(tr[i].getAttribute("pid"));
                });
            }
            pagenation(res.totalpage,res.perpage,page);
        }
    });
}

function trAjax(pk){
     $.ajax({
         type: "GET",
         url: root+"/product/"+pk,
        
         success: function (res) {
        	 let product = document.getElementById("product");
             product.style.display="";
             product.innerHTML="";
             product.innerHTML =
             `
             <form id="regist">
                 <div class="form-group">
                 <label for="id">상품번호:</label>
                 <input type="text" class="form-control" id="pid" placeholder="상품번호" value="${res.pid}" name="pid" readonly>
                 </div>
                 <div class="form-group">
                 <label for="name">상품명:</label>
                 <input type="text" class="form-control" id="pname" value="${res.pname}" placeholder="상품명" name="pname">
                 </div>
                 <div class="form-group">
                 <label for="price">가격:</label>
                 <input type="text" class="form-control" id="price" value="${res.price}" placeholder="가격" name="price">
                 </div>
                 
                 <div class="form-group">
                 <label for="des">설명:</label>
                 <input type="text" class="form-control" id="des" value="${res.des}" placeholder="설명" name="des">
                 </div>
             </form>
             <button type="button" id="update_btn" class="btn btn-primary">상품수정</button>
             <button type="button" id="delete_btn" class="btn btn-primary">상품삭제</button>
             `; 

            document.getElementById("update_btn").addEventListener("click",()=>{
                let form = document.getElementById("regist");
            	$.ajax({
                    type: "PUT",
                    url:  root+"/product/change",
                    headers:{
                        "Content-Type":"application/json"
                    },
                    data: JSON.stringify(formTojson(form)),
                    dataType: "json",
                    success: function (res) {
                        if(res>=1){
                            resetval(pid,pname,price,des);
//                        	document.getElementById("pid").value="";
//                        	document.getElementById("pname").value="";
//                        	document.getElementById("price").value="";
//                        	document.getElementById("des").value="";
                            startLoadAjax(1);
                        }else{
                             alert("다시 시도해주세요");
                        }
                    }
                });
            });

            document.getElementById("delete_btn").addEventListener("click",()=>{
            	$.ajax({
                    type: "DELETE",
                    url:  root+"/product/change/"+res.pid,
                    
                    success: function (res) {
                    	
                        if(res>=1){
                        	resetval(pid,pname,price,des);
//                        	document.getElementById("pid").value="";
//                        	document.getElementById("pname").value="";
//                        	document.getElementById("price").value="";
//                        	document.getElementById("des").value="";
                            startLoadAjax(1);
                        }else{
                             alert("다시 시도해주세요");
                        }
                    }
                });
            });
             
         }

        
     });
     
}

function resetval(){
    for(let i=0;i<arguments.length;i++){
    	console.log(arguments[i]);
    	arguments[i].value="";
    }
}
// 총페이지수, 한페이지당 목록 수, 현재 페이지
function pagenation(total, per, current){
	let pagegroup = Math.ceil(current/per);
	let respage = Math.ceil(total/per);
    let each =per;
	let pagenaion = document.getElementsByClassName("pagination")[0];
	pagenaion.innerHTML="";
    let i;
    let htmlIn="";
    if(pagegroup==1){
        htmlIn+=`<li class="page-item pre disabled"><a class="page-link">Previous</a></li>`;
    }else{
        htmlIn+=`<li class="page-item"><a class="page-link" idx="${(pagegroup*per)-per}">Previous</a></li>`;
    }
    if(respage<=per){
        each=respage;
    }
	for(i=((pagegroup-1)*per)+1;i<pagegroup+each;i++){
        if(i==current){
            htmlIn+=`<li class="page-item active"><a class="page-link" idx="${i}">${i}</a></li>`;
        }else{
            htmlIn+=`<li class="page-item"><a class="page-link" idx="${i}">${i}</a></li>`;
        }
		
	}
    if(pagegroup==respage || respage<=per){
        htmlIn+=`<li class="page-item disabled"><a class="page-link">next</a></li>`;
    }else{
        htmlIn+=`<li class="page-item next"><a class="page-link" idx="${i+1}">next</a></li>`;
    }
    pagenaion.innerHTML=htmlIn;

    let atag = document.getElementsByClassName("page-link");

    for(let j=0;j<atag.length;j++){
        atag[j].addEventListener("click",()=>{
            startLoadAjax(atag[j].getAttribute("idx"));
        });
    }

}

