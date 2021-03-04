let inner;
let lottoarr;
let color =["#F39C12", "#C0392B","#3498DB","#85929E","#2ECC71","#9B59B6"];
let index;
window.onload = function () {
  var box = document.querySelector('.box');
  
  document.getElementById("startbtn").addEventListener("click", () => {
    inner =null;
    lottoarr=[];
    box.innerHTML='';
    index=0;
    start();
  });
  document.getElementById("retry").addEventListener("click",()=>{
    inner =null;
    lottoarr=[];
    box.innerHTML='';
    index=0;
    start();
  });
};
function start() {
  inner = setInterval(lotto, 1000);
}

function lotto() {
  var box = document.querySelector('.box');

  let s = Math.floor(Math.random() * 45) + 1;
  let ck = false;
  for (let j = 0; j < lottoarr.length; j++) {
    if (lottoarr[j] == s) {
      ck = true;
    }
  }
  if (!ck) {
    lottoarr.push(s);
    box.innerHTML+=` <div style="background-color: ${color[index]};" >${s}</div>`;
    index++;
    console.log(s);
  }
  
  if (lottoarr.length == 6) {
    clearInterval(inner);
  }
}
