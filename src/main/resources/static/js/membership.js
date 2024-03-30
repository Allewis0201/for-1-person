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