window.addEventListener('DOMContentLoaded', (event) => {
    const urlParams = new URLSearchParams(window.location.search);
    const error = urlParams.get('error');
    if (error === 'accessForbidden') {
    alert('접근 하실 수 없습니다.');
}
});

