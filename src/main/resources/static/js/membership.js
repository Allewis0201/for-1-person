function checkSubmit() {
    var submitButton = document.querySelector('.btn-submit button');
    if(isUser && isNickname) {
        submitButton.disabled = false;
    } else {
        submitButton.disabled = true;
    }
}

var isUser = false;
var isNickname = false;

document.addEventListener('DOMContentLoaded', function (){
    document.getElementById('password_check').addEventListener('keyup', function (event){
        var password = document.getElementById('password').value;
        var password_check = document.getElementById('password_check').value;
        var pw_check_msg = document.getElementById('pw_check_msg');

        if (password === password_check){
            pw_check_msg.textContent = '비밀번호가 일치합니다';
        }
        else{
            pw_check_msg.textContent = '비밀번호 일치하지 않습니다.';
        }
    });
});

document.addEventListener('DOMContentLoaded', function (){
    var form = document.getElementById('form')
    form.addEventListener('submit', function (event){
        var password = document.getElementById('password').value;
        var password_check = document.getElementById('password_check').value;

        if (password !== password_check){
            event.preventDefault();
        }
    });
});

document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('usernameOverlay').addEventListener('click', function () {
        var userId = document.getElementById('userId').value;
        if(userId) {
            fetch('/checkUsername?userId=' + userId)
                .then(response => response.json())
                .then(data => {
                    if(data.isAvailable) {
                        alert('사용 가능한 아이디입니다.');
                        isUser = true;
                    }
                    else {
                        alert('이미 사용중인 아이디입니다.');
                        isUser = false;
                    }
                    checkSubmit();
                });
        }
    });

    document.getElementById('nicknameOverlay').addEventListener('click', function () {
        var nickname = document.getElementById('nickname').value;
        if(nickname) {
            fetch('/checkNickname?nickname=' + nickname)
                .then(response => response.json())
                .then(data => {
                    if(data.isAvailable) {
                        alert('사용 가능한 닉네임입니다.');
                        isNickname = true;
                    }
                    else {
                        alert('이미 사용중인 닉네임입니다.');
                        isNickname = false;
                    }
                    checkSubmit();
                });
        }
    });

    document.getElementById('form').addEventListener('submit', function (event) {
        if(!isUser || !isNickname) {
            alert('아이디와 닉네임 중 하나 이상이 이미 사용 중입니다. 다시 확인해 주세요.');
            event.preventDefault();
        }
    });

});