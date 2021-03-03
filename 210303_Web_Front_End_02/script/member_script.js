window.onload = function () {
    document.getElementById("submitbtn").onclick = function () {
        var registe = document.getElementById("registration");
        var input = registe.querySelectorAll("input");
        var pw = input[1].value;
        var check = input[2].value;

        if (!checkPw(pw)) {
            alert('숫자와 영문자 조합으로 6자리 이상 사용해야 합니다.');
        } else {
            if (pw != check) {
                alert("패스워드가 불일치합니다.");
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