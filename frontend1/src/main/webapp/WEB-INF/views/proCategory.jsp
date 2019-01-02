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
				<li class="active">Products</li>
			</ol>
		</div>
	</div>
		<div class="single-related-products">
		<div class="container">
			<h3 class="animated wow slideInUp" data-wow-delay=".5s">All Products Under</h3>
			<p class="est animated wow slideInUp" data-wow-delay=".5s"> ${catId.cat_name}</p>
			<div class="new-collections-grids">
			<c:if test="${empty prodList }">
				<tr>
					<td colspan="10" align="center">No Record Exists !!</td>
				</tr>
			</c:if>
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
<!-- //breadcrumbs -->
			 
			 
			 
			 
			 
<jsp:include page="footer.jsp"/>

</body>
</html>