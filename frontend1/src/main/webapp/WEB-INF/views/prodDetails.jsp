<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
          <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
           <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
           
<title>Rohtash Sons Engineering Industries</title>

</head>
<body>

<jsp:include page="header.jsp"/>

	
	
	
	
	<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="${pageContext.request.contextPath }/"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
				<li class="active">Details</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->
<!-- single -->
	<div class="single">
		<div class="container">
			<div class="col-md-8 single-right">
				<div class="col-md-5 single-right-left animated wow slideInUp" data-wow-delay=".5s">
					<div class="flexslider">
						<span class="slides">
							<span data-thumb="images/si.jpg">
								<div class="thumb-image"> <img src="${pageContext.request.contextPath }/resources/${prod.pro_imagename }" data-imagezoom="true" class="img-responsive"> </div>
							
							</span>
							
							
						</span>
					</div>
					<!-- flixslider -->
						<script defer src="js/jquery.flexslider.js"></script>
						<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
						<script>
						// Can also be used with $(document).ready()
						$(window).load(function() {
						  $('.flexslider').flexslider({
							animation: "slide",
							controlNav: "thumbnails"
						  });
						});
						</script>
					<!-- flixslider -->
				</div>
				<div class="col-md-7 single-right-left simpleCart_shelfItem animated wow slideInRight" data-wow-delay=".5s">
					<h3>${prod.pro_name}</h3>
					<%-- <h4>${prod.pro_writer}</h4>
					 --%><h4><span class="item_price"><i class="fa fa-inr"></i> ${prod.pro_price}</span></h4>
					
					<%-- <div class="description">
						<h5><i>Description</i></h5>
						<p>This is a book of ${prod.pro_name } written by ${prod.pro_writer } </p>
					</div>
					 --%>
						<div class="clearfix"> </div>
					
					<div class="section" style="padding-bottom:20px;">
					<form action="${pageContext.request.contextPath }/addToCart" method="post">
					<input type="hidden" value="${prod.pro_id }" name="pro_id"/>
					<input type="hidden" value="${prod.pro_price }" name="pro_price"/>
					<input type="hidden" value="${prod.pro_imagename }" name="pro_imagename"/>
					<input type="hidden" value="${prod.pro_stock }" name="pro_stock"/>
					<input type="hidden" value="${prod.pro_name }" name="pro_name"/>
					
					<div class="occasion-cart">
						
						<input class="btn btn-warning btn-lg" type="submit" value="Add To Cart"/>
					</div>
					</form>
				</div>
					
					
				</div>
				<div class="clearfix"> </div>
				
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //single -->
<!-- single-related-products -->
	<div class="single-related-products">
		<div class="container">
			<h3 class="animated wow slideInUp" data-wow-delay=".5s">Related Products</h3>
			<p class="est animated wow slideInUp" data-wow-delay=".5s">You may also like</p>
			<div class="new-collections-grids">
			<c:forEach items="${prodList }" var="pro">
				<div class="col-md-3 new-collections-grid">
					<div class="new-collections-grid1 animated wow slideInLeft" data-wow-delay=".5s">
						<div class="new-collections-grid1-image">
							<a href="${pageContext.request.contextPath }/productDetails?pro_id=${pro.pro_id }" class="product-image"><img src="${pageContext.request.contextPath }/resources/${pro.pro_imagename }" alt=" " class="img-responsive"></a>
							<div class="new-collections-grid1-image-pos">
								<a href="${pageContext.request.contextPath }/productDetails?pro_id=${pro.pro_id }">Quick View</a>
							</div>
							
						</div>
						<h4><a href="${pageContext.request.contextPath }/productDetails?pro_id=${pro.pro_id }">${pro.pro_name }</a></h4>
						<div class="new-collections-grid1-left simpleCart_shelfItem">
							<h6><span class="item_price"><i class="fa fa-inr"></i> ${pro.pro_price}</span></h6>
						</div>
					</div>
				</div>
			</c:forEach>
				
				
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
<!-- //single-related-products -->
	
	
	<jsp:include page="footer.jsp"/>
	</body></html>