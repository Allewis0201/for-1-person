function activateModal() {
    const modal = document.getElementById('modal');
    const btn_open_modal = document.getElementById('informationClick');
    const btn_close_modal = document.getElementById('btn_close_modal');

    btn_open_modal.addEventListener('click', () => {
        modal.classList.remove('hidden');
    });

    btn_close_modal.addEventListener('click', () => {
        modal.classList.add('hidden');
    });
}

window.onload = function() {
    activateModal();
}
