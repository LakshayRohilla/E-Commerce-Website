 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Rohtash Sons Engineering Industries</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link  rel="stylesheet" href='<c:url value="/resources/css/style.css"/>'/>
	 <link rel="stylesheet" type="text/js" href='<c:url value="/resources/js/bootstrap.min.js"/>'/>
	


<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Best Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="resources/css1/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="resources/css1/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="resources/js1/jquery.min.js"></script>
<!-- //js -->
<!-- cart -->
<script src="resources/js1/simpleCart.min.js"></script>
<!-- cart -->
<!-- for bootstrap working -->
<script type="text/javascript" src="resources/js1/bootstrap-3.1.1.min.js"></script>
<!-- //for bootstrap working -->
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- timer -->
<link rel="stylesheet" href="resources/css1/jquery.countdown.css" />
<!-- //timer -->
<!-- animation-effect -->
<link href="resources/css1/animate.min.css" rel="stylesheet"> 
<script src="resources/js1/wow.min.js"></script>
<script>
 new WOW().init();
</script>
<!-- //animation-effect -->
</head>
	
<body>
<!-- header -->
	<div class="header">
		<div class="container">
			<div class="header-grid">
				<div class="header-grid-left animated wow slideInLeft" data-wow-delay=".5s">
				 <c:if test='<%=(Boolean)session.getAttribute("loggedIn")==null%>'> 
       
					<ul>
						<li><i class="glyphicon glyphicon-log-in" aria-hidden="true"></i><a href="goToLogin">Login</a></li>
						<li><i class="glyphicon glyphicon-book" aria-hidden="true"></i><a href="goToRegister">Register</a></li>
					</ul>
				 </c:if> 
				</div>
				<div class="header-grid-right animated wow slideInRight" data-wow-delay=".5s">
					<ul class="social-icons">
						<li><a href="https://www.facebook.com/MotoHead-Lakshay-203630676709339/" class="facebook"></a></li>
						<li><a href="www.twitter.com" class="twitter"></a></li>
						<li><a href="www.facebook.com" class="g"></a></li>
						<li><a href="https://www.instagram.com/motohead_lakshay/" class="instagram"></a></li>
						
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="logo-nav">
				<div class="logo-nav-left animated wow zoomIn" data-wow-delay=".5s">
					<h1><a href="${pageContext.request.contextPath }/">Rohtash Sons Engineering Industries<span>JanakPuri , Delhi</span></a></h1>
				</div>
				<div class="logo-nav-left1">
					<nav class="navbar navbar-default">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header nav_2">
						<button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
					</div> 
					<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
						<ul class="nav navbar-nav">
							<li class="active"><a href="${pageContext.request.contextPath }/" class="act">Home</a></li>	
							<!-- Mega Menu -->
							<li><a href="${pageContext.request.contextPath }/allProducts">All Products</a></li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">Categories <b class="caret"></b></a>
								<ul class="dropdown-menu">
									<!-- <div class="row">
										<div class="col-sm-4">
											<ul class="multi-column-dropdown">
												 --><c:forEach items="${catlist }" var="catVal">
        	
        											<li><a href="<c:url value="/viewProducts?cat_id=${catVal.cat_id }"/>" >${catVal.cat_name }</a></li>
        										</c:forEach>
											<!-- 
										</div> -->
										
										<div class="clearfix"></div>
									<!-- </div> -->
								</ul>
							</li>
							<li><a href="${pageContext.request.contextPath }/goToAbout">About Us</a></li>
							<li><a href="${pageContext.request.contextPath }/goToContact">Contact Us</a></li>
							 <c:if test='<%=(Boolean)session.getAttribute("loggedIn")!=null&&(Boolean)session.getAttribute("loggedIn")==true%>'>
    						<li><a href="${pageContext.request.contextPath }/showCart">Cart</a></li>
    						
    						<c:if test='<%=(String)session.getAttribute("user")==null%>'>
						       <li><a href="${pageContext.request.contextPath }/adding">Admin</a></li>
						      <li class="dropdown">
						      <a>Admin Ops<span class="caret"></span>
						      <ul class="dropdown-menu">
						      <li><a href="${pageContext.request.contextPath }/catAdminList">Manage Category</a></li>
						      <li><a href="${pageContext.request.contextPath }/productAdminList">Manage Products</a></li>
						      <li><a href="${pageContext.request.contextPath }/suppAdminList">Manage Supplier</a></li>
						       </ul></a>
						      </li></c:if> 
    				<li><a href="${pageContext.request.contextPath }/cart" style="color:black">
						<img src="resources/images/bag.png" alt="" /> Cart</a></li>
						
					
						
						<li class="dropdown">
						<a style="color:black">
					      <span class="img-circle"><%=session.getAttribute("usertitle")%></span> <%=session.getAttribute("name")%>
					       <span class="caret"></span></a>
					        <ul class="dropdown-menu">
					         <li><a href="<c:url value="/myAccount"/>">My Account</a></li>
					         <li><a href="<c:url value="/myOrders"/>">My Orders</a></li>
					         <li><a href="<c:url value="/perform_logout"/>">
					         <span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
					        </ul>
					     </li></c:if>
					     
				
						</ul>
					</div>
					</nav>
				</div>
				
				
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
<!-- //header -->
</body></html>