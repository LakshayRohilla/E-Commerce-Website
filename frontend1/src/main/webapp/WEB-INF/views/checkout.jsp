<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>

<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
          <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
           <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
           
<title>Rohtash Sons Engineering Industries</title>

</head>
<body><jsp:include page="header.jsp"/>

  <% 
         				Date date = new Date();
         				//out.print( "<h2 align = \"center\">" +date.toString()+"</h2>");
         				%>
  <!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="${pageContext.request.contextPath }/cart"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Cart</a></li>
				<li class="active">Checkout</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->
<!-- login -->
	<div class="login">
		<div class="container">
			<h3 class="animated wow zoomIn" data-wow-delay=".5s">Shipping Details</h3>
			<p class="est animated wow zoomIn" data-wow-delay=".5s">Please enter shipping details.</p>
			<div class="login-form-grids animated wow slideInUp" data-wow-delay=".5s">
				<form action="${pageContext.request.contextPath }/Orderprocess" method="post">
					<c:set var="gtot" value="0"></c:set>
					<c:forEach var="c" items="${cart }">
						<c:set var="gtot" value="${gtot + c.cartPrice * c.cartStock }"></c:set>
					</c:forEach>
					<input name="name" type="text" placeholder="Name" required=" " maxlength="25" pattern="[A-Za-z]+[ ]*[A-Za-z]*" title="Enter a valid name" >
					<input name="mobile" type="text" placeholder="Contact No." required=" " pattern="[0-9]{10}" title="Enter a 10 digit mobile number" maxlength="10" >
					<input name="address" type="text" placeholder="Shipping Address" required=" " maxlength="255" >
					<label>Select Payment</label>
					<input type="hidden" value="${gtot }" name="total"/>
					<input type="hidden" value="<%date.toString(); %>" name="date"/>
					<br><br>
					<select name="payment">
					<option value="COD">Cash on delivery</option>
					<option value="Net">Net Banking</option>
					</select>
					<br><br>
					<h4>Grand Total : <i class="fa fa-inr"></i> <c:out value="${gtot }"></c:out></h4>
												
					<br><br><input type="submit" value="Proceed">
				</form>
			</div>
			<h4 class="animated wow slideInUp" data-wow-delay=".5s">Go back to</h4>
			<p class="animated wow slideInUp" data-wow-delay=".5s"><a href="${pageContext.request.contextPath }/cart">Cart</a> (Or) go back to <a href="${pageContext.request.contextPath }/">Home<span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></a></p>
		</div>
	</div>
<!-- //login -->
 
 
 
<jsp:include page="footer.jsp"/>

</body>
</html>