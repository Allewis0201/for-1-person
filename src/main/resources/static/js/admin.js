document.addEventListener('DOMContentLoaded', function (){
    document.getElementById('allCheck').addEventListener('change', function (){
        var checkMark = this.checked;
        var checks = document.querySelectorAll('input[name="userIdCollect"]');

        checks.forEach(function (check){
            check.checked = checkMark;
        })
    })
})