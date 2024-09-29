window.addEventListener('scroll', function() {
    var header = document.getElementById('header');
    if (window.scrollY === 0) {
        header.classList.remove('scrolled');
    } else {
        header.classList.add('scrolled');
    }
});
// Xóa hết tất cả thông tin form đăng kí
function clearForm() {
    // Lấy tất cả các phần tử input, select và textarea trong form
    var elements = document.querySelectorAll('form input, form select, form textarea');
    
    // Lặp qua từng phần tử và xóa giá trị của chúng
    elements.forEach(function(element) {
        element.value = '';
    });
}

const data = {
    "Hà Nội": ["Ba Đình", "Hoàn Kiếm", "Tây Hồ", "Long Biên"],
    "TP. Hồ Chí Minh": ["Quận 1", "Quận 2", "Quận 3", "Quận 4"],
    "Đà Nẵng": ["Hải Châu", "Thanh Khê", "Sơn Trà", "Ngũ Hành Sơn"]
};

function updateDistricts() {
    const provinceSelect = document.getElementById("province");
    const districtSelect = document.getElementById("district");
    const selectedProvince = provinceSelect.value;

    // Xóa các tùy chọn hiện tại của huyện
    districtSelect.innerHTML = "";

    // Thêm các tùy chọn huyện mới dựa trên tỉnh đã chọn
    if (selectedProvince) {
        const districts = data[selectedProvince];
        districts.forEach(function(district) {
            const option = document.createElement("option");
            option.value = district;
            option.text = district;
            districtSelect.appendChild(option);
        });
    }
}
