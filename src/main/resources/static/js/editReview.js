document.addEventListener('DOMContentLoaded', function() {

    // 수정 버튼 이벤트 리스너
    const modifyButton = document.getElementById('modify-btn');
    if (modifyButton) {
        modifyButton.addEventListener('click', function(event) {
            event.preventDefault(); // 기본 동작 차단

            let articleId = this.getAttribute('data-articleid');
            let title = document.getElementById('title').value;
            let content = myEditor.getData();
            let score = document.getElementById('score').value;

            // 서버로 데이터 전송
            fetch(`/api/review/${articleId}`, {
                method: 'PUT',
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    title: title,
                    content: content,
                    score: score
                })
            }).then(response => {
                if(response.ok) {
                    alert('수정이 완료되었습니다');
                    location.replace(`/review/${articleId}`);
                } else {
                    alert('수정에 실패했습니다');
                }
            });
        });
    }
});

function setInitialRating() {
    const currentScore = parseInt(document.getElementById('score').value, 10); // 현재 별점 값
    const stars = document.querySelectorAll('.star i');

    stars.forEach((star, index) => {
        if (index < currentScore) {
            star.classList.remove('far');
            star.classList.add('fas');
        }
    });
}

document.addEventListener('DOMContentLoaded', function() {
    setInitialRating();
});
