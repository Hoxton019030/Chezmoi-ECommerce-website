/*
Shop All頁面由Ajax產生
 */
$(document).ready(function () {
    //$('#loadAllProduct').click(function(){
    $('#tbody').empty();
    $('#pageNumber').empty();
    fetch("http://localhost:8080/Chezmoi/test/s").then(function (response) {
        return response.json();
    }).then(function (array) {

        $.each(array, function (index, value) {

            $('#tbody')
                .append('<div class="col-lg-3 col-md-6 col-sm-12 pb-1">')
                .append('<div class="card product-item border-0 mb-4">')
                .append('<div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">')
                .append('<img class="img-fluid w-300"src="http://localhost:8080/Chezmoi/getMainPic/' + value.photoId + '" style="height:278; weight:226" alt="">')
                .append('</div>')
                .append('<div class="card-body border-left border-right text-center p-0 pt-4 pb-3">')
                .append('<a href="${contextRoot}/shop/productDetail?productId=' + value.series + '">')
                .append('<h6 class="text-truncate mb-3">' + value.productName + '</h6>')
                .append('</a>')
                .append('<div class="d-flex justify-content-center">')
                .append('<h6 id="saleprice">' + value.price + '</h6>')
                .append('</div>')
                .append('</div>')
                .append('</div>')
            // .append($('<td class="align-middle"><img src="http://localhost:8080/Chezmoi/getMainPic/'+value.photo.photoId+'" style="width: 190px;height:auto">'))
            // .append($('<td class="align-middle">').text(value.name))
            // .append($('<td class="align-middle">').text(value.price))
            // ($('<td class="align-middle">').text(value.price))
        })

    })
})


