<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

            <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8">
                <title>Chezmoi 韓國女裝</title>
                <meta content="width=device-width, initial-scale=1.0" name="viewport">
                <meta content="Free HTML Templates" name="keywords">
                <meta content="Free HTML Templates" name="description">

                <!-- Favicon -->
                <link href="https://img.onl/fUrHvw" rel="icon">

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

            </head>

            <body>

                <!-- Topbar Start -->
                <jsp:include page="../layout/navbar.jsp"></jsp:include>
                <!-- Topbar End -->

                <!-- Page Header Start -->
                <div class="container-fluid">
                    <div class="align-items-center justify-content-center" style="min-height: 500px; display: flex;">
                        <div class="row question1">
                            <div class="col-lg-12 text-center">
                                <h2 class="font-weight-semi-bold text-uppercase mb-3" style="margin-right: 1em;">
                                    Q1:妳認為別人對妳的第一印象是?</h2>
                            </div>
                            <div class="col-lg-12 text-center mb-3">
                                <button class="btn btn-sm btn-primary q1" value="1">
                                    <h4 class="font-weight-semi-bold" style="margin-bottom: 0;">
                                        溫柔婉約的淑女</h4>
                                </button>
                            </div>
                            <div class="col-lg-12 text-center mb-3">
                                <button class="btn btn-sm btn-primary q1" value="4">
                                    <h4 class="font-weight-semi-bold" style="margin-bottom: 0;">
                                        沉著的冰山美人</h4>
                                </button>
                            </div>
                            <div class="col-lg-12 text-center mb-3">
                                <button class="btn btn-sm btn-primary q1" value="2">
                                    <h4 class="font-weight-semi-bold" style="margin-bottom: 0;">
                                        保守純樸的少女</h4>
                                </button>
                            </div>
                            <div class="col-lg-12 text-center mb-3">
                                <button class="btn btn-sm btn-primary q1" value="3">
                                    <h4 class="font-weight-semi-bold" style="margin-bottom: 0;">
                                        倍受寵愛的少女</h4>
                                </button>
                            </div>
                            <div class="col-lg-12 text-center mb-3">
                                <button class="btn btn-sm btn-primary q1" value="5">
                                    <h4 class="font-weight-semi-bold" style="margin-bottom: 0;">
                                        熱戀中的小女孩</h4>
                                </button>
                            </div>
                        </div>
                        <div class="row question2" style="display: none;">
                            <div class="col-lg-12 text-center">
                                <h2 class="font-weight-semi-bold text-uppercase mb-3" style="margin-right: 1em;">
                                    Q2:早上剛起床，來一杯?</h2>
                            </div>
                            <div class="col-lg-12 text-center mb-3">
                                <button class="btn btn-sm btn-primary q2" value="5">
                                    <h4 class="font-weight-semi-bold" style="margin-bottom: 0;">
                                        香甜的熱可可</h4>
                                </button>
                            </div>
                            <div class="col-lg-12 text-center mb-3">
                                <button class="btn btn-sm btn-primary q2" value="2">
                                    <h4 class="font-weight-semi-bold" style="margin-bottom: 0;">
                                        清甜的蘋果汁</h4>
                                </button>
                            </div>
                            <div class="col-lg-12 text-center mb-3">
                                <button class="btn btn-sm btn-primary q2" value="4">
                                    <h4 class="font-weight-semi-bold" style="margin-bottom: 0;">
                                        還是不喝了吧</h4>
                                </button>
                            </div>
                            <div class="col-lg-12 text-center mb-3">
                                <button class="btn btn-sm btn-primary q2" value="3">
                                    <h4 class="font-weight-semi-bold" style="margin-bottom: 0;">
                                        玫瑰荔枝醋</h4>
                                </button>
                            </div>
                            <div class="col-lg-12 text-center mb-3">
                                <button class="btn btn-sm btn-primary q2" value="">
                                    <h4 class="font-weight-semi-bold" style="margin-bottom: 0;">
                                        熱戀中的小女孩</h4>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Page Header End -->

                <!-- Footer Start -->
                <jsp:include page="../layout/footer.jsp"></jsp:include>
                <!-- Footer End -->


                <!-- Back to Top -->

                <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>

                <!--JavaScript & Jquery-->
                <script src="https://code.jquery.com/jquery-3.6.1.js"
                    integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>

                <!-- JavaScript Libraries -->
                <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
                <script src="${contextRoot}/lib/easing/easing.min.js"></script>
                <script src="${contextRoot}/lib/owlcarousel/owl.carousel.min.js"></script>

                <!-- Template Javascript -->
                <script src="${contextRoot}/js/main.js" type="text/javascript"></script>

                <!-- Contact Jquery File -->
                <script src="${contextRoot}/js/jquery-3.6.1.min.js" type="text/javascript"></script>

                <!-- Contact Javascript File -->
                <script src="${contextRoot}/mail/jqBootstrapValidation.min.js" type="text/javascript"></script>
                <script src="${contextRoot}/mail/contact.js" type="text/javascript"></script>
                <script type="text/javascript">
                    var choose1;
                    $('.q1').click(function () {
                        choose1 = $(this).val();
                        $('.question1').css("display", "none");
                        $('.question2').css("display", "block");
                        console.log(choose1)
                    })
                    console.log(choose1)

                </script>

            </body>

            </html>