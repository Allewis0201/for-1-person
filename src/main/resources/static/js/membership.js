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
                    } else {
                        alert('이미 사용중인 아이디입니다.');
                    }
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
                    } else {
                        alert('이미 사용중인 닉네임입니다.');
                    }
                });
        }
    });
});