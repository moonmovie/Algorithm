/**
 * 
 */

document.querySelector(".far").addEventListener("click", function(){
    var tempElem = document.createElement('textarea');
    tempElem.value = 'sosm8500@gmail.com';  
    document.body.appendChild(tempElem);
    alert("ì´ë©ì¼ ì£¼ìê° ë³µì¬ëììµëë¤");
    tempElem.select();
    document.execCommand("copy");
    document.body.removeChild(tempElem);
  });

document.getElementById("send").addEventListener("click", function(){
	alert("íìê°ìì´ ëììµëë¤.")
});