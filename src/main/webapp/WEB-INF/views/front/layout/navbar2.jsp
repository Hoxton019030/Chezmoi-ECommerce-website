
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

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
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="${contextRoot}/lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="${contextRoot}/css/style.css" rel="stylesheet">

</head>
<body>


	<!-- Topbar Start -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarScroll">
			<ul class="navbar-nav mr-auto my-2 my-lg-0 navbar-nav-scroll"
				style="max-height: 100px;">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown" aria-expanded="false"> Shop </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="${contextRoot}/shop">All</a></li>
						<li><a class="dropdown-item" href="${contextRoot}/shop/top">Top</a></li>
						<li><a class="dropdown-item"
							href="${contextRoot}/shop/bottom">Bottom</a></li>
						<li><a class="dropdown-item" href="${contextRoot}/shop/outer">Outer</a></li>
						<li><a class="dropdown-item" href="${contextRoot}/shop/dress">Dress</a></li>
						<li><a class="dropdown-item" href="${contextRoot}/shop/acc">Accessories</a></li>

					</ul></li>

				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/notice">Notice</a></li>
				<li class="nav-item"><a class="nav-link"
					href="$https://www.instagram.com/chezmoiiiiiii/?hl=en">Instagram</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/contact">Contact</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="${contextRoot}/">Account</a></li>
					</ul>
		</div>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarScroll" aria-controls="navbarScroll"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<span> <a class="nav-link" href="${contextRoot}/"><img
				src="https://img.onl/fUrHvw" width="50" height="50"> 
				</a>
				</span>
				 <a
			class="navbar-brand" href="${contextRoot}/cartAll"><img
			src="https://img.onl/Vzb1us" width="20" height="20"></a>


	</nav>
</body>
</html>