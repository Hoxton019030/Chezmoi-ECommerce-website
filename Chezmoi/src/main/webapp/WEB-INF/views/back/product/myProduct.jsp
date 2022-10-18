<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
                <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
                <!DOCTYPE html>
                <html>

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
                    <link
                        href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
                        rel="stylesheet">

                    <!-- Font Awesome -->
                    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
                        rel="stylesheet">

                    <!-- Libraries Stylesheet -->
                    <link href="${contextRoot}/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

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
                                    <a href="admin_index.html" class="nav-item nav-link active"><img
                                            src="${contextRoot}/img/logo.png" width="50" height="50">
                                    </a>
                                </div>
                            </div>
                            <div class="col-lg-5 d-none d-lg-block pt-3" style="padding-left:1em;">

                                <a href="admin_index.html" class="text-decoration-none">
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
                            <div class="col-lg-9">
                                <div class="col-lg-12 border-secondary  border mb-5 mt-3"
                                    style="padding-left: 0; padding-right:0;">
                                    <div class="card-header bg-secondary border-0">
                                        <h4 class="font-weight-semi-bold m-0">我的商品</h4>
                                    </div>
                                    <div class="card-body border-bottom">

                                        <form class="btn-block" action="">
                                            <div class="input-group justify-content-between ">
                                                <div class="d-flex pt-1 mb-2 ">
                                                    <select class="rounded-sm p-0 " name="commodity ">
                                                        <option value="name">商品名稱</option>
                                                        <option value="number">商品編號</option>
                                                    </select>
                                                </div>
                                                <input type="text" class="form-control p-4 m-1" placeholder="search">
                                                <div class="submit">
                                                    <input class="btn-primary m-1 rounded-sm border-1" type="submit"
                                                        value="search">
                                                </div>
                                            </div>

                                        </form>
                                    </div>

                                    <div class="container-fluid row px-xl-4 ">
                                        <div class="row  px-xl-3  pt-3 ">

                                            <div class="col-lg-12">
                                                <nav
                                                    class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                                                    <div class="collapse navbar-collapse  justify-content-between"
                                                        id="navbarCollapse">
                                                        <div class="mr-auto py-0">
                                                            <ul class="nav navbar-nav">
                                                                <li class="active mr-3">
                                                                    <button class="btn btn-sm btn-primary"
                                                                        id="getAllProduct">全部商品</button>
                                                                </li>
                                                                <li class="dropdown mr-3">
                                                                    <a href="" class="dropdown-toggle"
                                                                        data-toggle="dropdown">
                                                                        按分類顯示
                                                                        <b class="caret"></b>
                                                                    </a>
                                                                    <ul class="dropdown-menu">
                                                                        <li class="dropdown-item"><a href="#"
                                                                                id="loadTopData">TOP</a>
                                                                        </li>
                                                                        <li class="dropdown-item"><a href="#"
                                                                                id="loadBottomData">BOTTOM</a>
                                                                        </li>
                                                                        <li class="dropdown-item"><a href="#"
                                                                                id="loadDressData">DRESS</a>
                                                                        </li>
                                                                        <li class="dropdown-item"><a href="#"
                                                                                id="loadOuterData">OUTER</a>
                                                                        </li>
                                                                        <li class="dropdown-item"><a href="#"
                                                                                id="loadAccData">ACCESSORITIES</a></li>
                                                                    </ul>
                                                                </li>
                                                                <li class="active mr-3"><a href="#"
                                                                        id="stateOnData">已上架商品</a></li>
                                                                <li class="active mr-3"><a href="#"
                                                                        id="stateOffData">未上架商品</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="">
                                                            <button class="btn btn-primary rounded-sm" type="button"
                                                                onclick="javascript:location.href='#'"
                                                                name="creatProduct" id="creatProduct">全部刪除
                                                            </button>
                                                        </div>
                                                    </div>
                                                </nav>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-lg-12 border-secondary  mb-5 mt-3"
                                        style="padding-left: 0; padding-right:0;">
                                        <div class="row px-xl-4 table-responsive p-0 m-0">
                                            <table class="table table-bordered text-center mb-5" id="table_contain">
                                                <thead class="bg-secondary text-dark">
                                                    <tr>
                                                        <th>選取</th>
                                                        <th>商品圖片</th>
                                                        <th>商品編號</th>
                                                        <th>商品名稱</th>
                                                        <th>顏色</th>
                                                        <th>尺寸</th>
                                                        <th>單價</th>
                                                        <th>狀態</th>
                                                        <th>修改</th>
                                                        <th>刪除</th>
                                                    </tr>
                                                </thead>
                                                <tbody class="align-middle" id="tbody">
                                                    <!--                                     <tr class="text-center"> -->
                                                    <!--                                         <td><input class="" type="checkbox" style="zoom:150%"></td> -->
                                                    <!--                                         <td class="align-middle"> -->
                                                    <!--                                             <img src="" style="width: 50px;height:auto"> -->
                                                    <!--                                         </td> -->
                                                    <!--                                         <td class="align-middle"><a class="a font-weight-medium" href="" -->
                                                    <!--                                                 target="_blank">100000</a></td> -->
                                                    <!--                                         <td class="align-middle">Colorful -->
                                                    <!--                                             Stylish Shirt</td> -->
                                                    <!--                                         <td class="align-middle">黑</td> -->
                                                    <!--                                         <td class="align-middle">S</td> -->
                                                    <!--                                         <td class="align-middle">9457</td> -->
                                                    <!--                                         <td class="align-middle">ON</td> -->
                                                    <!--                                         <td class="align-middle"> -->
                                                    <!--                                             <a class="btn btn-sm btn-primary" href="">修改</a> -->
                                                    <!--                                         </td> -->
                                                    <!--                                         <td class="align-middle"> -->
                                                    <!--                                             <a class="btn btn-sm btn-primary" href="">刪除</a> -->
                                                    <!--                                         </td>    -->
                                                    <!--                                     </tr> -->
                                                </tbody>
                                            </table>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Back to Top -->
                    <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>
                    <!-- JavaScript Libraries -->
                    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                    <script
                        src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
                    <script src="${contextRoot}/lib/easing/easing.min.js"></script>
                    <script src="${contextRoot}/lib/owlcarousel/owl.carousel.min.js"></script>

                    <!-- Contact Javascript File -->
                    <script src="${contextRoot}/mail/jqBootstrapValidation.min.js"></script>
                    <script src="${contextRoot}/js/main.js"></script>
                    <script src="${contextRoot}/js/jquery-3.1.1.min.js"></script>
                    <!-- Template Javascript -->
                    <script src="${contextRoot}/js/getProductAjax.js"></script>
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
                    <script type="text/javascript">var ctx = "${contextRoot}";</script>

                </body>

                </html>