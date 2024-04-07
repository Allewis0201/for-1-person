document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('VIPForm');

    form.onsubmit = function(e) {
        e.preventDefault();

        const formData = new FormData(form);

        fetch(form.action, {
            method: 'POST',
            body: formData
        })
            .then(response => response.json())
            .then(data => {
                if (data.redirectUrl) {
                    window.location.href = data.redirectUrl;
                }
            })
            .catch(error => console.error('Error:', error));
    };
});
