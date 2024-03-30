function rateStar(star) {
    const rating = parseInt(star.getAttribute('data-rate'));
    const stars = document.querySelectorAll('.star i');
    stars.forEach((star, index) => {
        if(index < rating) {
            star.classList.remove('far');
            star.classList.add('fas');
        } else {
            star.classList.remove('fas');
            star.classList.add('far');
        }
    });
}
