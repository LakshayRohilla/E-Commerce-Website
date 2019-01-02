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
<div class="container">
<br/><center>
<div class="col-sm-offset-3 col-sm-6" style="box-shadow:0 0 10px grey;padding:16px;margin-bottom:25px;">
<img src="<c:url value="/resources/download.png"/>" height=200 width=200/>
<h1><b>Order Placed Successfully</b></h1><br/>
<h2><b>Order ID :</b> ${orderId}</h2><br/>
<i><h2>Thank You For Choosing us</h2></i> <br/>
<div class="col-sm-5">
<a href="index" class="btn btn-success btn-block">Continue Shopping....</a>
</div>
<div class="col-sm-offset-2 col-sm-5">
<a href="myOrders" class="btn btn-success btn-block">View Orders</a>
</div>
</div>
</center>
</div>
<%@include file="footer.jsp"%>

</body>
</html>