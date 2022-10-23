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


    <link href="${contextRoot}/css/style.css" rel="stylesheet">
    <link href="${contextRoot}/css/admin_style.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->

    <style>
        li,
        ul {
            list-style: none;
            padding: 0%;
        }
    </style>
</head>

<body>
    <!-- Topbar Start -->
    <div class="container-fluid align-items-center justify-content-center">
        <div class="row">
            <div class="col-lg-1 d-none d-lg-block pt-1">
                <div class="container-fluid">
                    <a href="admin_index.html" class="nav-item nav-link active"><img src="img/logo.png" width="50"
                            height="50"></a>

                </div>
            </div>
            <div class="col-lg-5 d-none d-lg-block pt-3" style="padding-left:1em;">

                <a href="admin_index.html" class="text-decoration-none">
                    <h1 class="display-5 font-weight-semi-bold">後台管理中心</h1>
                </a>
            </div>
        </div>

    </div>
    <!-- Navbar Start -->
    <div class="container-fluid mb-5">
        <div class="row border-top px-xl-3">
            <div class="col-lg-3 d-none d-lg-block pt-3 pr-0">
                <div class="container-fluid">
                    <ul class="p-0 menu border">
                        <li class="p-0">
                            <a
                                class="btn shadow-none d-flex border-bottom align-items-center justify-content-between bg-primary text-white w-100">會員管理</a>
                            <ul class="inmenu">
                                <li><a href="member.html"
                                        class="btn d-flex border-bottom align-items-center justify-content-between text-black w-100">會員資料表</a>
                                </li>
                            </ul>
                            <ul class="inmenu">
                                <li><a href="messageCheck.html"
                                        class="btn d-flex border-bottom align-items-center justify-content-between text-black w-100">留言板查看/回覆</a>
                                </li>
                            </ul>

                        </li>
                        <li>
                            <a
                                class="btn shadow-none d-flex border-bottom align-items-center justify-content-between bg-primary text-white w-100">產品管理</a>
                            <ul class="inmenu">
                                <li><a href="myProduct.html"
                                        class="btn d-flex border-bottom align-items-center justify-content-between text-black w-100">我的產品</a>
                                </li>
                            </ul>
                            <ul class="inmenu">
                                <li><a href="addProduct.html"
                                        class="btn d-flex border-bottom align-items-center justify-content-between text-black w-100">產品上架</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a
                                class="btn shadow-none d-flex border-bottom align-items-center justify-content-between bg-primary text-white w-100">結帳管理</a>
                            <ul class="inmenu">
                                <li><a href="shipping.html"
                                        class="btn d-flex border-bottom align-items-center justify-content-between text-black w-100">物流管理</a>
                                </li>
                                <li><a href="payment.html"
                                        class="btn d-flex border-bottom align-items-center justify-content-between text-black w-100">金流管理</a>
                                </li>
                                <li><a href="coupon.html"
                                        class="btn d-flex border-bottom align-items-center justify-content-between text-black w-100">折扣碼設定</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a
                                class="btn shadow-none d-flex border-bottom align-items-center justify-content-between bg-primary text-white w-100">訂單管理</a>
                            <ul class="inmenu">
                                <li><a href="orderSales.html"
                                        class="btn d-flex border-bottom align-items-center justify-content-between text-black w-100">銷售訂單</a>
                                </li>
                                <li><a href="orderShip.html"
                                        class="btn d-flex border-bottom align-items-center justify-content-between text-black w-100">訂單出貨</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a
                                class="btn shadow-none d-flex border-bottom align-items-center justify-content-between bg-primary text-white w-100">營運表現</a>
                            <ul class="inmenu">
                                <li><a href="salesData.html"
                                        class="btn d-flex border-bottom align-items-center justify-content-between text-black w-100">商品銷售狀況</a>
                                </li>
                                <li><a href="salesReport.html"
                                        class="btn d-flex align-items-center justify-content-between text-black w-100">業績報表</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="row col-lg-9 justify-content-center pl-0">

                <div class="col-lg-8 border-secondary border mb-5 mt-3 mr-3" style="padding-left: 0; padding-right:0;">
                    <div class="card-header border bg-secondary border-0">
                        <h4 class="font-weight-semi-bold m-0">折扣碼設定</h4>
                    </div>
                    <form:form action="${contextRoot}/Back/postEditCoupon" method="post" modelAttribute="edit">
                    
                    <form:input type="hidden" path="couponId"/>
                    
                    <div class="card-body">
                        <div class="d-flex justify-content-between pt-1 mb-2" style="clear:both;">
                            <h6 class=" font-weight-medium" >折扣券名稱</h6>
                        </div>
                        <div class="input-group">
                            <input type="text" class="form-control p-4 mb-2" id="couponName" name="couponName" required />
                        </div>
                        <div class="d-flex justify-content-between pt-2 mb-2" style="clear:both;">
                            <h6 class=" font-weight-medium">折扣券代碼</h6>
                        </div>
                        <div class="input-group">
                            <input type="text" class="form-control p-4 mb-2" id="couponCode" name="couponCode" required />
                        </div>
                        <div class="d-flex justify-content-between pt-2 mb-2" style="clear:both;">
                            <h6 class=" font-weight-medium">折扣金額</h6>
                        </div>
                        <div class="input-group">
                            <input type="text" class="form-control p-4 mb-2" id="discountPrice" name="discountPrice" required />
                        </div>
                        <div class="d-flex justify-content-between pt-2 mb-2" style="clear:both;">
                            <h6 class=" font-weight-medium">最低消費金額</h6>
                        </div>
                        <div class="input-group">
                            <input type="text" class="form-control p-4 mb-2" id="minimum" name="minimum" required />
                        </div>
                        <div class="d-flex justify-content-between pt-2 mb-2" style="clear:both;">
                            <h6 class=" font-weight-medium">折扣期限</h6>
                        </div>
                        <div class="input-group">
                            <input type="text" class="form-control p-4 mb-2" placeholder="2022/9/26 00:00" id="dateStart" name="dateStart" required />
                        </div> 
                        <div class="input-group">
                            <input type="text" class="form-control p-4 mb-2" placeholder="2022/11/20 23:59" id="dateEnd" name="dateEnd" required />
                        </div>
                        <div class="input-group-append pt-4">
                        	<input type="submit" class="btn btn-primary" value="新增折扣碼">
<!--                             <button class="btn btn-primary" >新增折扣碼</button> -->
                        </div>
                    </div>
              </form:form>
                </div>
            </div>
            <!-- Back to Top -->
            <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


            <!-- JavaScript Libraries -->
            <script src="${contextRoot}/js/jquery-3.6.1.min.js"></script>
            <!--             <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script> -->
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
            <script src="${contextRoot}/lib/easing/easing.min.js"></script>
            <script src="${contextRoot}/lib/owlcarousel/owl.carousel.min.js"></script>

            <!-- Contact Javascript File -->
            <script src="${contextRoot}/mail/jqBootstrapValidation.min.js"></script>
            <script src="${contextRoot}/mail/contact.js"></script>

            <!-- Template Javascript -->
            <script src="${contextRoot}/js/main.js"></script>
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
</body>

</html> 