window.addEventListener('scroll', function() {
    var header = document.getElementById('header');
    if (window.scrollY === 0) {
        header.classList.remove('scrolled');
    } else {
        header.classList.add('scrolled');
    }
});
