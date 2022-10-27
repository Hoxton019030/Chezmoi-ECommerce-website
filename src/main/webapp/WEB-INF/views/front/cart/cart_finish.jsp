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

            </head>


            <body>

                <!-- Topbar Start -->
              <jsp:include page="../layout/navbar.jsp"></jsp:include>
                <!-- Topbar End -->

                <!-- Page Header Start -->
                <div class="container-fluid  mb-0 mt-5">
                    <div class="align-items-center justify-content-center" style="min-height: 200px; display: flex;">
                        <h1 class="font-weight-semi-bold text-uppercase mb-3">01</h1>
                        <h2 class="font-weight-semi-bold text-uppercase mb-3" style="margin-right: 1em;">確認訂購明細
                        </h2>
                        <h1 class="font-weight-semi-bold text-uppercase mb-3">02</h1>
                        <h2 class="font-weight-semi-bold text-uppercase mb-3" style="margin-right: 1em;">填寫訂購資料</h2>
                        <h1 class="font-weight-semi-bold text-uppercase mb-3 text-primary">03</h1>
                        <h2 class="font-weight-semi-bold text-uppercase mb-3 text-primary" style="margin-right: 1em;">
                            完成訂購</h2>


                    </div>
                </div>
                <!-- Page Header End -->


                <!-- Cart Start -->
                <div class="container-fluid pt-3">

                    <div class="row px-xl-5 table-responsive mb-5">

                        <div class=" px-xl-5 border-0">
                            <h3 class="font-weight-semi-bold mb-2">您的訂單已成立</h3>
                        </div>
                        <div class="row px-xl-5">

                            <div class="col-lg-8 border-secondary  border mb-2"
                                style="padding-left: 0; padding-right:0;">
                                <div class="card-header bg-secondary border-0">
                                    <h4 class="font-weight-semi-bold m-0">訂單資料</h4>
                                </div>
                                <div class="card-body">
                                    <div class="d-flex justify-content-between pt-1 mb-2">
                                        <h6 class=" font-weight-medium">訂單編號:
                                            <c:out value="${Orders.orderId}" />
                                        </h6>
                                    </div>
                                    <div class="d-flex justify-content-between pt-1 mb-2">
                                        <h6 class=" font-weight-medium">下單時間:
                                            <c:out value="${Date}" />
                                        </h6>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="card border-secondary border mb-2">
                                    <div class="card-header bg-secondary border-0">
                                        <h4 class="font-weight-semi-bold m-0">訂單備註</h4>
                                    </div>
                                    <div class="card-body">
                                        <div class="d-flex justify-content-between pt-1 mb-2">
                                            <h6 class=" font-weight-medium">
                                                <c:out value="${Orders.notes}" />
                                            </h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class=" border-0">
                                <h5 class="font-weight-medium pt-1 mb-2">我們已發送訂單明細至您的電子信箱:</h5>
                                <div class="d-flex justify-content-between pt-1 mb-2">
                                    <h6 class=" font-weight-medium">將於確認您的款項後出貨,出貨進度可至<a
                                            class="text-primary font-weight-medium" href="orderDetail.html"
                                            target="_blank">訂單明細</a></h6>

                                    <h6 class="font-weight-medium">查詢</h6>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <!-- Cart End -->
                <!-- Footer Start -->
                 <jsp:include page="../layout/footer.jsp"></jsp:include>
                <!-- Back to Top -->
                <a href="#" class="btn btn-primary back-to-top" style="margin-right: 0px"><i
                        class="fa fa-angle-double-up"></i></a>

                <!-- Footer End -->


                <!-- Back to Top -->
                <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


                <!-- JavaScript Libraries -->
                <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
                <script src="lib/easing/easing.min.js"></script>
                <script src="lib/owlcarousel/owl.carousel.min.js"></script>

                <!-- Contact Javascript File -->
                <script src="mail/jqBootstrapValidation.min.js"></script>
                <script src="mail/contact.js"></script>

                <!-- Template Javascript -->
                <script src="js/main.js"></script>

                <script type="text/javascript">
                    window.addEventListener('popstate', function (event) {
                        history.pushState(null, document.title, location.href);
                    });

                </script>
            </body>

            </html>