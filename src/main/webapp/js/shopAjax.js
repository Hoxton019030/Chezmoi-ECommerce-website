// /*
// Shop All頁面由Ajax產生
//  */
// $(document).ready(function(){
//     //$('#loadAllProduct').click(function(){
//         $('#tbody').empty();
//         $('#pageNumber').empty();
//         fetch("http://localhost:8080/Chezmoi/test/s").then(function(response){
//             return response.json();
//         }).then(function(array){
//
//             $.each(array,function (index,value) {
//                 $('#tbody').append('<tr class="text-center">')
//                     .append($('<td class="align-middle"><img src="http://localhost:8080/Chezmoi/getMainPic/'+value.photoId+'" style="width: 190px;height:auto">'))
//                     .append(value.productName)
//                     .append((value.price))
//
//                     // .append($('<td class="align-middle"><img src="http://localhost:8080/Chezmoi/getMainPic/'+value.photo.photoId+'" style="width: 190px;height:auto">'))
//                     // .append($('<td class="align-middle">').text(value.name))
//                     // .append($('<td class="align-middle">').text(value.price))
//                     // ($('<td class="align-middle">').text(value.price))
//             })
//
//             })
//         })
//
//
