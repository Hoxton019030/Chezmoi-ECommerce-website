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
                 <meta name="viewport" content="width=device-width, initial-scale=1">
    			<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
                
                <!-- jQ -->
                <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
body {
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
}

* {
  box-sizing: border-box;
}

.row {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}

.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.container {
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}

input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

/* .btn { */
/*   background-color: #4CAF50; */
/*   color: white; */
/*   padding: 12px; */
/*   margin: 10px 0; */
/*   border: none; */
/*   width: 100%; */
/*   border-radius: 3px; */
/*   cursor: pointer; */
/*   font-size: 17px; */
/* } */

.btn:hover {
  background-color: #45a049;
}

a {
  color: #2196F3;
}

hr {
  border: 1px solid lightgrey;
}

span.price {
  float: right;
  color: grey;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
@media (max-width: 800px) {
  .row {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
}

    </style>
</head>
<body>
 <!-- Topbar Start -->
<jsp:include page="../layout/navbar.jsp"></jsp:include>
 <div class="container-fluid pt-0">
 <div class="row px-xl-5">
  <div class="col-lg-8">

                            <div class="card border-secondary mb-5">
                                <div class="card-header bg-secondary border-0">
                                    <h4 class="font-weight-semi-bold m-0">訂購明細</h4>
                                </div>
           <div class="row px-xl-4 table-responsive mb-5">
            <table class="table table-bordered text-center mb-5">
                <thead class="bg-secondary text-dark">
                    <tr>
                        <th>商品編號</th>
                        <th>商品名稱</th>
                        <th>商品圖片</th>
                        <th>顏色</th>
                        <th>尺寸</th>
                        <th>數量</th>
                        <th>單價</th>
                        <th>小計</th>
                    </tr>
                </thead>
                <tbody class="align-middle">
                <c:forEach items="${OrderDetail}" var="o">
                    <tr>
                        <td class="align-middle">${o.productId}</td>
                        <td class="align-middle">${o.productName}</td>
                        <td class="align-middle">
                        <img src="http://localhost:8080/Chezmoi/getMainPic/${o.photoId}" style="width: 5em;"></td>
                        <td class="align-middle">${o.productColor}</td>
                        <td class="align-middle">${o.productSize}</td>
                        <td class="align-middle">${o.quantity}</td>
                        <td class="align-middle">${o.price}</td>
                        <td class="align-middle">${o.total}</td>
                    </tr>
                 </c:forEach>
                </tbody>
            </table>
        </div>
        </div>
    </div>
 <div class="col-lg-4 border-secondary  border mb-5" style="padding-left: 0; padding-right:0;">
 <div class="card-header bg-secondary border-0">
                                <h4 class="font-weight-semi-bold m-0">詳細付款資訊</h4>
                            </div>
                            <div class="card-body">
             <form:form action="${contextRoot}/cart/paypal" method="post" modelAttribute="order">
                <div class="col-50">
                    <label>Accepted Cards</label>
                    <label>Total</label>
                    <form:input path="price" type="text" />
                    <label>Currency</label>
                    <form:input path="currency" type="text" id="currency" name="currency" placeholder="Enter Currency" />
                    <label>Payment Method</label>
                    <form:input path="method" type="text" id="method" name="method" placeholder="Payment Method" />
                    <label>Intent</label>
                    <form:input path="intent" type="text" id="intent" name="intent" value="sale" />
                    <label>Payment Description</label>
                    <form:input path="description" type="text" id="description" name="description" placeholder="Payment Description" />
                </div>

                <input type="submit" value="Continue to checkout" class="btn">
            </form:form>
        </div>
    </div>
    </div>
 				<!-- Footer Start -->
                <jsp:include page="../layout/footer.jsp"></jsp:include>
                <!-- Footer End -->


                <!-- Back to Top -->

                <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>

                <!--JavaScript & Jquery-->
                <script src="https://code.jquery.com/jquery-3.6.1.js"></script>

                <!-- JavaScript Libraries -->
               
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

                <!-- Ajax & other function -->
                <script src="${contextRoot}/js/cartAjax.js"></script>

</body>
</html>