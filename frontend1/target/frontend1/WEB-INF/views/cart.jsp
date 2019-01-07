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
           
<title>Engineeric</title>

</head>
<body>

<jsp:include page="header.jsp"/>




<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="${pageContext.request.contextPath }/"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
				<li class="active">Cart</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->
<!-- checkout -->
	<div class="checkout">
		<div class="container">
		<c:if test="${empty cartInfo!=true }">
	
			<h3 class="animated wow slideInLeft" data-wow-delay=".5s">Your shopping cart contains: <span>${cartSize } Products</span></h3>
		</c:if>
			<div class="checkout-right animated wow slideInUp" data-wow-delay=".5s">
				<table class="timetable_sub">
					<thead>
						<tr>
							<th>SL No.</th>	
							<th>Product</th>
							<th class="span4">Quantity</th>
							<th>Product Name</th>
							<th>Product Price</th>
							<th>Sub Total</th>
							<th>Remove</th>
						</tr>
					</thead>
					<c:if test="${empty cartInfo }">
						<tr>
							<td colspan="10" align="center">No Record Exists !!</td>
						</tr>
					</c:if>
	
					
					<c:forEach var="p" varStatus="st" items="${cartInfo}">
	
					
					<tr class="rem1">
						<td class="invert">${st.index+1 }</td>
						<td class="invert-image"><img src="${pageContext.request.contextPath }/resources/${p.cartImage }" alt=" " class="img-responsive" /></td>
						<td class="invert">
							 <div class="quantity" > 
								<div class="quantity-select">                           
									<a href="${pageContext.request.contextPath }/sub?cartId=${p.cartId }"><div class="entry value-minus">&nbsp;</div></a>
									<div class="entry value"><span>${p.cartStock }</span></div>
									<a href="${pageContext.request.contextPath }/add?cartId=${p.cartId }"><div class="entry value-plus active">&nbsp;</div></a>
								</div>
							</div>
						</td>
						<td class="invert">${p.cartProductName }</td>
						<td class="invert"><i class="fa fa-inr"></i> <c:out value="${p.cartPrice }"></c:out></td>
						<td class="invert"><i class="fa fa-inr"> </i> <c:out value="${p.cartStock * p.cartPrice}"></c:out></td>
						<td class="invert">
							
									<c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>
									<a href="<c:url value="/deletePCart/${p.cartId}"/>" role="button">Delete</a>		
							 	
							
						</td>
					</tr>
					</c:forEach>
					
								<!--quantity-->
									
								<!--quantity-->
				</table>
			</div>
			<div class="checkout-left">	
				<div class="checkout-left-basket animated wow slideInLeft" data-wow-delay=".5s">
					<h4>Continue to basket</h4>
					<ul>
					<c:forEach var="p" varStatus="s" items="${cartInfo}">
	
						<li>Product ${s.index+1 } <i>-</i> <span>$<i class="fa fa-inr"></i> <c:out value="${p.cartPrice }"></c:out> </span></li>
					
					 <c:set var="gtot" value="${gtot+ p.cartStock*p.cartPrice }"></c:set>
				</c:forEach>
						<li>Total <i>-</i> <span> <i class="fa fa-inr"> </i> <c:out value="${gtot }"></c:out></span></li>
					</ul>
				</div>
				<c:if test="${empty cartInfo }">
					<div class="checkout-right-basket animated wow slideInRight" data-wow-delay=".5s">
						<a href="${pageContext.request.contextPath }/"><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>Shop Here</a>
					</div>
				</c:if>
				<c:if test="${empty cartInfo!=true }">
					<div class="checkout-right-basket animated wow slideInRight" data-wow-delay=".5s">
						<a href="${pageContext.request.contextPath }/"><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>Continue Shopping</a>
					</div>
					<div class="checkout-right-basket animated wow slideInRight" data-wow-delay=".5s">
						<a href="${pageContext.request.contextPath }/checkout"><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>Checkout</a>
					</div>
				</c:if>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
<!-- //checkout -->








<jsp:include page="footer.jsp"/>

</body>
</html>