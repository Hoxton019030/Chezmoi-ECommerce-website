// 姓名
// 只能輸入中文
function checkChName(el) {
    el.addEventListener('input', e => {
        setTimeout(() => {
            return e.target.value = e.target.value.replace(/[a-zA-Z0-9]|[ws]|[!#$€£%&'"`()*+-./:：;；…,，。「」【】=<>?@{}^|[]]/g, '')
        }, 0)
    }, false);
}
const jsName = document.getElementById('Name');
checkChName(jsName);

// 生日
$(function () {
    $('#birthdate').datepicker({
        theme: 'default',
        changeMonth: true,
        changeYear: true,
        date: null,
        dateFormat: "yy-mm-dd",
        maxDate: 0,
        minDate: '-50Y',
        beforeShow: function () {
            $("#birthdate").css('font-size', 4)
        }
    });
});
