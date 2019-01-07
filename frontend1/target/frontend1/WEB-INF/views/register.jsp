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
<body><jsp:include page="header.jsp"/>

  
  <!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="${pageContext.request.contextPath }/"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
				<li class="active">Login Page</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->
<!-- login -->
	<div class="login">
		<div class="container">
			<h3 class="animated wow zoomIn" data-wow-delay=".5s">Register</h3>
			<p class="est animated wow zoomIn" data-wow-delay=".5s">Please create an account first.</p>
			<div class="login-form-grids animated wow slideInUp" data-wow-delay=".5s">
			<b style="color:red">${userCreate }</b>
				<form action="addUserDetails" method="post">
					<input name="name" type="text" placeholder="Name" required=" " maxlength="25" pattern="[A-Za-z]+[ ]*[A-Za-z]*" title="Enter a valid name" >
					<input name="emailId" type="email" placeholder="Email Id" required=" " title="Enter a valid email address" >
					<input name="contact" type="text" placeholder="Contact No." required=" " pattern="[0-9]{10}" title="Enter a 10 digit mobile number" maxlength="10" >
					<input name="password" type="password" placeholder="Password" required=" " pattern="[A-za-z0-9]{8,}" title="Atleast have 8 characters, special characters or spaces are not allowed" >
					<input name="address" type="text" placeholder="Address" required=" " maxlength="255" >
					<input type="submit" value="Sign Up">
				</form>
			</div>
			<h4 class="animated wow slideInUp" data-wow-delay=".5s">For New People</h4>
			<p class="animated wow slideInUp" data-wow-delay=".5s"><a href="goToRegister">Register Here</a> (Or) go back to <a href="${pageContext.request.contextPath }/">Home<span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></a></p>
		</div>
	</div>
<!-- //login -->
 
 
 
<jsp:include page="footer.jsp"/>

</body>
</html>