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
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search Product names.." title="Type in a name">


<h2>Product List For Admin</h2>
<table class="table table-hover" id="myTable" class="display" border="2" width="80" align="center">
	<tr>
		<th>Sr. No.</th>
		<th>Product ID</th>
		<th>Product Name</th>
		<th>Product Supplier</th>
		<th>Product Category</th>
		<!-- <th>Description</th> -->
		<th>Stock</th>
		<th>Price</th>
		<th>Image</th>
		<th class="span2">Action</th>
	</tr>
	
	<c:if test="${empty prodList }">
		<tr>
			<td colspan="10" align="center">No Record Exists !!</td>
		</tr>
	</c:if>
	
	
	<c:forEach var="p" varStatus="st" items="${prodList }">
		<tr>
			<td><c:out value="${st.count }"></c:out></td>
			<td><c:out value="${p.pro_id }"></c:out></td>
			<td id="name"><c:out value="${p.pro_name }"></c:out></td>
			<td><c:out value="${p.pro_supplier.supp_name }"></c:out></td>
			<td><c:out value="${p.pro_category.cat_name }"></c:out></td>
			<%-- <td><c:out value="${p.pro_writer }"></c:out></td> --%>
			<td><c:out value="${p.pro_stock }"></c:out></td>
			<td><i class="fa fa-inr"></i> <c:out value="${p.pro_price }"></c:out></td>
			<td><img src="${pageContext.request.contextPath }/resources/${p.pro_imagename }" width="50px" height="50px"></td>
			<td class="span4">
				<c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>
					<a href="<c:url value="updateProd?pro_id=${p.pro_id}"/>" id="update" class="btn btn-success myBoldFont">Update</a>
					<a href="<c:url value="deleteProd?pro_id=${p.pro_id}"/>" id="delete" class="btn btn-danger myBoldFont">Delete</a>
				
			</td>
		</tr>
	</c:forEach>
	

</table>
</div>


<script>
function myFunction() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[2];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>
<jsp:include page="footer.jsp"/>

</body>
</html>