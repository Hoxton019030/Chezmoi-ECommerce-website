<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
    <title>Chezmoi 後台管理中心</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="${contextRoot}/img/logo.jpg" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
        rel="stylesheet">

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="${contextRoot}/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
	<link href="${contextRoot}/css/jquery-ui.css" rel="stylesheet">
    <!-- Customized Bootstrap Stylesheet -->
    <link href="${contextRoot}/css/style.css" rel="stylesheet">
	
    <style>
        li,
        ul {
            list-style: none;
            padding: 0%;
        }

        li,
        ul {
            list-style: none;
        }
    </style>
</head>

<body>
    <!-- Topbar Start -->
    <div class="container-fluid align-items-center justify-content-center">
        <div class="row">
            <div class="col-lg-1 d-none d-lg-block pt-1">
                <div class="container-fluid">
                    <a href="admin.html" class="nav-item nav-link active"><img src="img/logo.png" width="50"
                            height="50"></a>

                </div>
            </div>
            <div class="col-lg-5 d-none d-lg-block pt-3" style="padding-left:1em;">

                <a href="admin.html" class="text-decoration-none">
                    <h1 class="display-5 font-weight-semi-bold">後台管理中心</h1>
                </a>
            </div>
        </div>

    </div>
    <!-- Topbar End -->

    <!-- Navbar Start -->
    <div class="container-fluid mb-5">
        <div class="row border-top px-xl-3">
            <div class="col-lg-3 d-none d-lg-block pt-3">
                <div class="container-fluid">
                    <ul class="p-0 menu border">
                        <li class="p-0">
                            <a
                                class="btn shadow-none d-flex border-bottom align-items-center justify-content-between bg-primary text-white w-100">會員管理</a>
                            <ul class="inmenu">
                                <li><a href="Product/add"
                                        class="btn d-flex border-bottom align-items-center justify-content-between text-black w-100">會員資料表</a>
                                </li>
                            </ul>
                            <ul class="inmenu">
                                <li><a href="留言板查看回覆.html"
                                        class="btn d-flex border-bottom align-items-center justify-content-between text-black w-100">留言板查看/回覆</a>
                                </li>
                            </ul>

                        </li>
                        <li>
                            <a
                                class="btn shadow-none d-flex border-bottom align-items-center justify-content-between bg-primary text-white w-100">產品管理</a>
                            <ul class="inmenu">
                                <li><a href="我的產品.html"
                                        class="btn d-flex border-bottom align-items-center justify-content-between text-black w-100">我的產品</a>
                                </li>
                            </ul>
                            <ul class="inmenu">
                                <li><a href="產品上架.html"
                                        class="btn d-flex border-bottom align-items-center justify-content-between text-black w-100">產品上架</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a
                                class="btn shadow-none d-flex border-bottom align-items-center justify-content-between bg-primary text-white w-100">結帳管理</a>
                            <ul class="inmenu">
                                <li><a href="物流管理.html"
                                        class="btn d-flex border-bottom align-items-center justify-content-between text-black w-100">物流管理</a>
                                </li>
                                <li><a href="金流管理.html"
                                        class="btn d-flex border-bottom align-items-center justify-content-between text-black w-100">金流管理</a>
                                </li>
                                <li><a href="折扣碼設定.html"
                                        class="btn d-flex border-bottom align-items-center justify-content-between text-black w-100">折扣碼設定</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a
                                class="btn shadow-none d-flex border-bottom align-items-center justify-content-between bg-primary text-white w-100">訂單管理</a>
                            <ul class="inmenu">
                                <li><a href="OrderDetail"
                                        class="btn d-flex border-bottom align-items-center justify-content-between text-black w-100">訂單出貨</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a
                                class="btn shadow-none d-flex border-bottom align-items-center justify-content-between bg-primary text-white w-100">營運表現</a>
                            <ul class="inmenu">
                                <li><a href="商品銷售狀況.html"
                                        class="btn d-flex border-bottom align-items-center justify-content-between text-black w-100">商品銷售狀況</a>
                                </li>
                                <li><a href="業績報表.html"
                                        class="btn d-flex align-items-center justify-content-between text-black w-100">業績報表</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-9">
                <div class="col-lg-8 border-secondary  border mb-5" style="padding-left: 0; padding-right:0;">
                    <div class="card-header bg-secondary border-0">
                        <h4 class="font-weight-semi-bold m-0">訂單出貨</h4>
                                </div>
                                <div>
                                    <div class="row">
                                        <!-- column -->
                                        <div class="col-12">
                                            <div class="card">
                                                <div class="card-body">
                                                    <!-- title -->
                                                    <div class="d-md-flex">
                                                        <div class="ms-auto">
                                                            <div class="dl">
                                                                <div class="wrap">
                                                                    <div class="search">
                                                                        <input type="search" class="light-table-filter" data-table="table v-middle" placeholder="請輸入關鍵字">
                                                                    </div>
                                                                 </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- title -->
                                                </div>
                                                <div class="table-responsive">
                                                    <table class="table v-middle">
                                                        <thead>
                                                            <tr class="bg-light">
                                                                <th class="border-top-0">訂單號碼</th>
                                                                <th class="border-top-0">訂單日期</th>
                                                                <th class="border-top-0">訂單狀態</th>
                                                                <th class="border-top-0">送件單號</th>
                                                                <th class="border-top-0">訂購人</th>
                                                                <th class="border-top-0">合計</th>
                                                            </tr>
                                                        </thead>
                                                        
                                                        <tbody id="orders">
                                                        	
                                                        	    
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                    </div>
                </div>


            </div>

        </div>
        <!-- Navbar End -->


        <!-- Cart Start -->

        <!-- Cart End -->


        <!-- Footer Start -->

        <!-- Footer End -->
        <div id="dialog" class="modal fade" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true"></div>

        <!-- Back to Top -->
        <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="mail/jqBootstrapValidation.min.js"></script>
        <script src="mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
        <script>
            $(document).ready(function () {
                $('.menu>li>a').click(function (e) {
                    e.preventDefault();
                    //點選到的.menu>li>a顯示裡面的.inmenu 
                    $(this).siblings('.inmenu').slideDown().parent().siblings().find('.inmenu').slideUp();
                    //點選到的.menu>li>a 顯示動態active
                    $(this).addClass('active').parent().siblings().find('a').removeClass('active');
                });
                
            });    
        </script>
        <script>
            function add(orderId){
            		$.ajax({
                    	url: 'http://localhost:8081/Chezmoi/order',
                    	method: 'put',
                        dataType:'text',
                        headers: { 
                            'Accept': 'application/json',
                            'Content-Type': 'application/json' 
                        },
                    	data: JSON.stringify({
                    		shippingCode: $('#add'+ orderId + ' > input').val(), orderId: orderId
                    	}),
                    }).done(function(res){
                        alert(res);
                        if(res==="建立成功"){
                            update();
                        }
                    })		
                }
                function update(){
                    $.ajax({
            	        url: 'http://localhost:8081/Chezmoi/order',
            	        method: 'get',
            	        dataType: 'json',
            	        data: {}
                    }).done(function(res){
            	        $('#orders').empty();
            	        for(order of res){
            		        let shippingInput = '<div id="add' + order.orderId + '"><input type="text" placeholder="請填寫單號"><button onclick="add(\''+order.orderId+'\')">送出</button></div>'
            		        $('#orders').append('<tr><td>' + '<a href="#" onclick="openDetail('+order.orderId+')">' + order.orderId + '</a>' + '</td><td>' + order.orderDate + '</td><td>' + order.orderState + '</td><td>' + (!order.shippingCode?shippingInput:order.shippingCode) + '</td><td>' + (order?.member?.memberName?order?.member?.memberName:'') + '</td><td>' + order.total + '</td></tr>')
            	        }

                    }).fail(function(err){
            	        });
            
                }

                function openDetail(id){
                    $.ajax({
                        url: 'http://localhost:8081/Chezmoi/order/'+ id,
                        method: 'get',
            	        dataType: 'json',
            	        data: {}
                    }).done(function(orderDetail){
                        $('#dialog').empty();



                        $('#dialog').append(
                            '<div class="modal-dialog">' +
                                '<div class="modal-content">' +
                                '<div class="modal-header">' +
                                    '<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>' +
                                    '<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>' +
                                    '</div>' +
                                '<div class="modal-body">' +
                                    '<table class="table v-middle">' + 
                                        '<thead>' +
                                            '<tr>' +
                                                '<th>訂單號碼</th>'+
                                                '<th>商品名稱</th>'+
                                                '<th>數量</th>'+
                                                '<th>價格</th>'+
                                            '</tr>' +
                                        '</thead>' +
                                        '<tbody>'+ 
                                            generateDetailTable(orderDetail) +
                                        '</tbody>' +
                                    '</table>' +
                                '</div>' +
                                '<div class="modal-footer">' +
                                    '<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>' +
                                '</div>' +
                                '</div>' +
                            '</div>'
                            )
                        $('#dialog').modal('show');

                    }).fail(function(err){
                        alert('查無資料')
            	        });
                    
                }

                function generateDetailTable(detailList) {
                    let table = ''
                    for (orderDetail of detailList) {
                        table += 
                            '<tr>'+
                                '<td>'+ orderDetail.orderId + '</td>' +
                                '<td>'+ orderDetail.productName + '</td>' +
                                '<td>'+ orderDetail.quantity + '</td>' +
                                '<td>'+ orderDetail.price + '</td>' +
                            '</tr>';
                    }

                    return table;
                }

            $(function() {
			    update(); 
			    
            
                
            
                // 建立 LightTableFilter
                var LightTableFilter = (function(Arr) {

                    var _input;

                    // 資料輸入事件處理函數
                    function _onInputEvent(e) {
                        _input = e.target;
                        var tables = document.getElementsByClassName(_input.getAttribute('data-table'));
                        Arr.forEach.call(tables, function(table) {
                            Arr.forEach.call(table.tBodies, function(tbody) {
                                Arr.forEach.call(tbody.rows, _filter);
                            });
                        });
                    }

                    // 資料篩選函數，顯示包含關鍵字的列，其餘隱藏
                    function _filter(row) {
                        var text = row.textContent.toLowerCase(), val = _input.value.toLowerCase();
                        row.style.display = text.indexOf(val) === -1 ? 'none' : 'table-row';
                    }
                    return {
                        // 初始化函數
                        init: function() {
                            var inputs = document.getElementsByClassName('light-table-filter');
                            Arr.forEach.call(inputs, function(input) {
                                input.oninput = _onInputEvent;
                            });
                        }
                    };
                })(Array.prototype);

                // 網頁載入完成後，啟動 LightTableFilter
                document.addEventListener('readystatechange', function() {
                    if (document.readyState === 'complete') {
                        LightTableFilter.init();
                    }
                });

            });
        </script>
</body>

</html>