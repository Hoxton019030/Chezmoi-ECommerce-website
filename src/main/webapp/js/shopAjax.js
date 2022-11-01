/*
Shop All頁面由Ajax產生
 */
$(document).ready(function(){
    //$('#loadAllProduct').click(function(){
        $('#tbody').empty();
        $('#pageNumber').empty();
        fetch("http://localhost:8080/Chezmoi/test/s").then(function(response){
            return response.json();
        }).then(function(array){

            $.each(array,function (index,value) {

                $('#tbody').append('<tr class="col-lg-3 col-md-6 col-sm-12 pb-1">')
                    .append(' <div class="card product-item border-0 mb-4">')
                    .append('<td class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">')
                    .append('<img class="img-fluid w-300" src="http://localhost:8080/Chezmoi/getMainPic/'+value.photoId+'" style="height:278; weight:226" alt=""/>')
                    .append('</td>')
                    .append('<div class="card-body border-left border-right text-center p-0 pt-4 pb-3">')
                    .append(' <td><a href="${contextRoot}/shop/productDetail?productId='+value.series+'">')
                    .append('  <h6 class="text-truncate mb-3">'+value.productName+'</h6></a>')
                    .append('</td>')
                    .append('<td class="d-flex justify-content-center">')
                    .append('<h6 id="saleprice">'+value.price+'</h6>')
                    .append('</td>')
                    .append('</div>')
                    .append('</div>')
                    .append('</tr>')

                    // .append($('<td class="align-middle"><img src="http://localhost:8080/Chezmoi/getMainPic/'+value.photo.photoId+'" style="width: 190px;height:auto">'))
                    // .append($('<td class="align-middle">').text(value.name))
                    // .append($('<td class="align-middle">').text(value.price))
                    // ($('<td class="align-middle">').text(value.price))
            })

            })
        })


