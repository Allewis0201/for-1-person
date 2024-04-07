document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('commentVipForm');

    form.onsubmit = function(e) {
        e.preventDefault();

        const formData = new FormData(form);
        const mapping = {};
        formData.forEach((value, key) => {
            mapping[key] = value;
        });

        fetch(form.action, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(mapping)
        })
            .then(response => response.json())
            .then(data => {
                if (data.redirectUrl) {
                    window.location.href = data.redirectUrl;
                }
                else{
                    window.location.reload();
                }
            })
            .catch(error => console.error('Error:', error));

    };
});

document.addEventListener('DOMContentLoaded', (event) => {
    document.querySelectorAll('.deleteCommentBtn').forEach(button => {
        button.addEventListener('click', function () {
            const commentId = this.getAttribute('commentId');
            if (confirm('정말 댓글을 삭제하실건가요?')) {
                fetch(`/api/comment/vip/${commentId}`, {
                    method: 'DELETE'
                }).then(response => {
                    if (response.ok) {
                        alert('댓글이 삭제되었습니다.');
                        location.reload();
                    }
                    else {
                        alert('댓글 삭제에 실패했습니다.');
                        window.location.href = data.redirectUrl;
                    }
                }).catch(error => {
                    console.error('Error:', error);
                    alert('댓글 삭제 중 오류가 발생했습니다.');
                });
            }
        });
    });
});