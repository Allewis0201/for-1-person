// <!--modal 자바스크립트 시작!-->

document.addEventListener('DOMContentLoaded', function () {
    const modal = document.getElementById('modal');
    const btn_open_modal = document.getElementById('informationClick');
    const btn_close_modal = document.getElementById('btn_close_modal');

    btn_open_modal.addEventListener('click', () => {
        modal.classList.remove('hidden');
    });

    btn_close_modal.addEventListener('click', () => {
        modal.classList.add('hidden');
    });
});
// <!--모달창 자바스크립트 완료!-->