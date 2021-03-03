/**
 * 
 */

document.querySelector(".far").addEventListener("click", function(){
    var tempElem = document.createElement('textarea');
    tempElem.value = 'sosm8500@gmail.com';  
    document.body.appendChild(tempElem);
    alert("이메일 주소가 복사되었습니다");
    tempElem.select();
    document.execCommand("copy");
    document.body.removeChild(tempElem);
  });

  const btn = document.querySelector(".fas");
  const menu = document.querySelector(".menu");
  btn.addEventListener("click",()=>{
     menu.classList.toggle('active');
     console.log(menu.classList)
  });
