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

<div class="container">
	<c:url value="/categoryUpdate" var="catUp"></c:url>
	<form action="${pageContext.request.contextPath }/categoryUpdate" method="post">
            
            <span id="reauth-email" class="reauth-email"></span>
            <input type="hidden" name="cat_id" value="${cat.cat_id }">
            
            
            <h4 class="input-title">Category Name</h4><br>
            <input value="${cat.cat_name }" type="text" name="cat_name" required/><br>
            
			<h4 class="input-title">Category Description</h4><br>
            <input value="${cat.cat_desc }" type="text" name="cat_desc" required/><br>
            
   
           
          	<div>
        	    <button class="btn btn-primary" type="submit" >Update</button>
        	    <button class="btn btn-warning" type="reset" >Cancel</button>
        	</div>
        </form>
</div>
 <jsp:include page="footer.jsp"/>
      
</body>
</html>