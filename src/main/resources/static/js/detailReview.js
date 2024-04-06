document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('commentReviewForm');

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
            })
            .catch(error => console.error('Error:', error));

    };
});