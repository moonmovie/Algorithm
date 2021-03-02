window.onload = function () {
    document.getElementById("submitbtn").onclick = function () {
        var registe = document.getElementById("registration");
        var input = registe.querySelectorAll("input");
        var pw = input[1].value;
        var check = input[2].value;

        if (!checkPw(pw)) {
            alert('ì«ìì ìë¬¸ì ì¡°í©ì¼ë¡ 6ìë¦¬ ì´ì ì¬ì©í´ì¼ í©ëë¤.');
        } else {
            if (pw != check) {
                alert("í¨ì¤ìëê° ë¶ì¼ì¹í©ëë¤.");
            }
        }

    }
};


function checkPw(password) {
    // 
    if (!/^[a-zA-Z,0-9]{6,25}$/.test(password)) {
        return false;
    }
}