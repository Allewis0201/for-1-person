document.addEventListener("DOMContentLoaded", function (){
    var username = document.getElementById("username");
    var rememberCheck = document.getElementById("remember-check");
    var save = localStorage.getItem("save");

    document.getElementById('login-form').addEventListener('submit', function(){
        if (rememberCheck.checked){
            localStorage.setItem("save", username.value)
        }
        else{
            localStorage.removeItem("save")
        }
    });

    if(save){
        username.value = save;
        rememberCheck.checked = true;
    }

});
