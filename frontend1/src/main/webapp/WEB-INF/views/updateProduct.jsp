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
	<c:url value="/productUpdate" var="proUp"></c:url>
		<form action="${pageContext.request.contextPath }/productUpdate" method="post" enctype="multipart/form-data">
            
            <span id="reauth-email" class="reauth-email"></span>
            <input type="hidden" name="pro_id" value="${prod.pro_id }">
            
            <h4 class="input-title">Product Name</h4><br>
            <input value="${prod.pro_name }" type="text" name="pro_name" required/><br>
            
           
            <h4 class="input-title">Product Stock</h4><br>
            <input value="${prod.pro_stock }" type="number" name="pro_stock" required/><br>
             
            <h4 class="input-title">Product price</h4><br>
            <i class="fa fa-inr"></i> <input value="${prod.pro_price }" type="number" name="pro_price" required/><br>
             
             <div class="form-group">
            <table>
            	<tr>
            		<td>Select Supplier</td>
            		<td><br>
        				<select name="pro_supplier.supp_id" id="suppName" class="form-control" required="required">
						<option value="" label="----------- Select Supplier -----------" disabled="true" selected/>
						<c:forEach items="${supplist }" var="sup">
							<option value="${sup.supp_id }">${sup.supp_name }</option>
						</c:forEach>
						</select>
    				</td>
    			</tr>
    		</table>
    		</div>  
            <div class="form-group">
            <table>
            	<tr>
            		<td>Select Category</td>
            		<td>
        				<select name="pro_category.cat_id" id="catName" class="form-control" required="required">
						<option value="" label="----------- Select Category -----------" disabled="true" selected/>
						<c:forEach items="${catlist}" var="cat">
							<option value="${cat.cat_id }">${cat.cat_name }</option>
						</c:forEach> 
						</select>
    				</td>
    			</tr>
    		</table>
    		</div>
    		   		
    		<div class="fileinput fileinput-new" data-provides="fileinput">
    			<table>
    				<tr>
    					<td>Product Image</td>
    					<td><input class="form-control" type="file" name="pro_image" accept="image/*"/></td>
    				</tr>
    			</table>
    		</div>
    		
    		<div>
        	    <button class="btn btn-primary" type="submit" >Update</button>
        	    <button class="btn btn-warning" type="reset" >Cancel</button>
        	</div>
        </form>

      </div>
     
  <jsp:include page="footer.jsp"/>
  
</body>
</html>