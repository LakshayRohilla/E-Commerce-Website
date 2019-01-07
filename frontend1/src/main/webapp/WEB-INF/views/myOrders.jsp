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
<br/>
<div class="list-group-item list-group-item-info" style="background-color:#d87140; color:black;">

<center><h2><b>My Orders</b></h2></center></div>
<c:if test="${empty orderInfo }">
<br/><center><h2><b>Nothing to Show</b></h2></center>
</c:if>
<c:forEach items="${cartInfo }" var="orderItem">
<br/><%-- <a href="Details?id=${orderItem.cartOrderID}"> --%>
<div style="box-shadow:0 0 10px grey;" class="table-responsive">
<div class="thumbnail col-sm-4">
<img src="${pageContext.request.contextPath }/resources/${orderItem.cartImage }" alt="${orderItem.cartProductName}" />
</div><div class="col-sm-8">
<table class="table">
<tr><td colspan="2">
	<h3>${orderItem.cartProductName}</h3>
	</td>
	</tr>
	<tr><td colspan="2"><h4><b>Order Id : ${orderItem.cartOrderID}</b></h4></td></tr>
  	<tr><td colspan="2"><h4><b>Quantity : ${orderItem.cartStock}</b></h4></td></tr>
	<tr><td colspan="2"><h4><b>OrderPlacedOn : ${orderItem.cartOrderPlacedOn}</b></h4></td></tr>
	<tr><td><b>Status : </b>Processing</td><td><b>Amount : <i class="fa fa-inr"></i> ${orderItem.cartPrice*orderItem.cartStock}</b>
  	<tr><td colspan="2"><h4><b>Expected delivery : In 7 Business Days</b></h4></td></tr>
	</td></tr></table></div></div>
  
</c:forEach>
</div><br/>
<%@include file="footer.jsp"%>
</body>
</html>