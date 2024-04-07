
document.addEventListener('DOMContentLoaded', function() {

    const modifyButton = document.getElementById('modify-btn');
    if (modifyButton) {
        modifyButton.addEventListener('click', function(event) {
            event.preventDefault(); // 기본 동작 차단

            let articleId = this.getAttribute('data-articleid');
            let title = document.getElementById('title').value;
            let content = myEditor.getData();

            fetch(`/api/vip/${articleId}`, {
                method: 'PUT',
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    title: title,
                    content: content,
                })
            }).then(response => {
                if(response.ok) {
                    alert('수정이 완료되었습니다');
                    location.replace(`/vip/${articleId}`);
                } else {
                    alert('수정에 실패했습니다');
                }
            });
        });
    }
});
