window.addEventListener('scroll', function() {
    const header = document.querySelectorAll('#header');
    const scrollPosition = window.scrollY + window.innerHeight / 2;

    header.forEach(header => {
        if (scrollPosition >= header.offsetTop && scrollPosition < header.offsetTop + header.offsetHeight) {
            header.style.backgroundColor = 'white'; // Thay đổi màu nền khi cuộn đến phần này
        } else {
            header.style.backgroundColor = 'white';
        }
    });
});
