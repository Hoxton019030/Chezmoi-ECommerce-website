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
                // .append('<div class="col-lg-3 col-md-6 col-sm-12 pb-1">')
                // .append('<div class="card product-item border-0 mb-4">')
                .append('<div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">' +
                    '\n <img class="img-fluid w-300" src="http://localhost:8080/Chezmoi/getMainPic/'+value.photoId+'" ' +
                    '\n style="width: 190px;height:auto"><div class="card-body border-left border-right text-center p-0 pt-4 pb-3"> ' +
                    '\n <a href="http://localhost:8080/Chezmoi/shop/productDetail?productId=T004-S-Cream%22%3E <h6 class="text-truncate mb-3">'+value.productName+'</h6></a>' +
                    '\n <div class="d-flex justify-content-center"> <h6 id="saleprice">'+value.price+'</h6></div> </div>')
                // .append('<>')
                // .append('</div>')
                // .append('<div class="card-body border-left border-right text-center p-0 pt-4 pb-3"> <a href="http://localhost:8080/Chezmoi/shop/productDetail?productId=T004-S-Cream%22%3E <h6 class="text-truncate mb-3">asdasd</h6></a><div class="d-flex justify-content-center"> <h6 id="saleprice">111</h6></div> </div>')
                // .append('')
                // .append('')
                // .append('</a>')
                // .append('<div class="d-flex justify-content-center"> <h6 id="saleprice">' + value.price + '</h6> </div>')
                // .append('')
                // .append('')
                // .append('</div>')
                // .append('</div>')
                // .append('</div>')
            // .append($('<td class="align-middle"><img src="http://localhost:8080/Chezmoi/getMainPic/'+value.photo.photoId+'" style="width: 190px;height:auto">'))
            // .append($('<td class="align-middle">').text(value.name))
            // .append($('<td class="align-middle">').text(value.price))
            // ($('<td class="align-middle">').text(value.price))
        })

    })
})


