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
<script type="text/javascript" src="<c:url value="/resources/js/myaccount.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/inputform.js"/>"></script>
<div style="width:80%; margin:auto;margin-top:1.5em;">
<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header headStyle">
					    Change Password
					    </div>
						<div class="modal-body" style="padding:40px 50px;">
							<form action="changePass" method="post" class="form-horizontal">
							<div class="form-group">
								<label class="control-label col-sm-5 myBoldFont" for="currentPass">Current Password</label>
								<div class="col-sm-7">
								<input type="text" name="currentPass" id="currentPass" class="form-control" required pattern="[A-za-z0-9]{8,}" title="Atleast have 8 characters, special characters are not allowed"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5 myBoldFont" for="newPass">New Password</label>
								<div class="col-sm-7">
								<input type="text" name="newPass" id="newPass" class="form-control" required pattern="[A-za-z0-9]{8,}" title="Atleast have 8 characters, special characters are not allowed"/>
								</div>
							</div>
							<div class="col-sm-6">
							<input type="submit" value="Change" class="btn btn-success btn-block myBoldFont"/></div>
							<div class="col-sm-6">
							<button class="btn btn-danger btn-block myBoldFont" data-dismiss="modal">Cancel</button>
							</div><br/>
							</form>
						</div>
					</div>
			    </div>
			</div>
<div class="panel-group">
		<div class="panel panel-primary">
			<div class="panel-heading text-center">
			<span>Account Details</span>
			</div>
	<div class="panel-body table-responsive">
				<table class="table"><form id="userTable" action="updateUser" method="post">
				<tr><th>Email ID</th><td>
				<input type="email" name="email" id="emailField" value="${user.emailId}" disabled required title="Enter a valid email address"/></td>
				<tr><th>Name</th><td>
				<input type="text" name="name" id="nameField" value="${user.name}" disabled required maxlength="25" pattern="[A-Za-z]+[ ]*[A-Za-z]*" title="Enter a valid name"/></td>
				<td><span class="glyphicon glyphicon-edit" id="nameBtn"></span><button type="submit" id="nameSave" class="btn btn-primary">Save</button></td></tr>
				<tr><th>Mobile Number</th><td>
				<input type="text" name="phone" id="mobileField" value="${user.contact}" disabled required pattern="[0-9]{10}" title="Enter a 10 digit mobile number" maxlength="10"/></td>
				<td><span class="glyphicon glyphicon-edit" id="mobileBtn"></span><button type="submit" id="mobileSave" class="btn btn-primary">Save</button></td></tr>
				<tr><th>Address</th><td>
				<textarea name="address" rows="3" id="addressField" disabled required maxlength="255">${user.address}</textarea></td>
				<td><span class="glyphicon glyphicon-edit" id="addressBtn"></span><button type="submit" id="addressSave" class="btn btn-primary">Save</button></td></tr>
				</form>
				<tr><th>Username</th><td colspan="2">${user.name}</td></tr>
				<tr><th>Password</th>
					<td colspan="2">
					<button type="button" class="btn btn-success btn-sm myBoldFont" id="myBtn">Change password</button> 
					<b>${info}</b>
					</td>
					</tr>
					<c:if test='<%=(String)session.getAttribute("user")!=null && ((String)session.getAttribute("user")).equals("user")%>'>
					<tr><th>Account</th>
					<td colspan="2">
					<a href="deactivateAccount" class="btn btn-danger btn-sm myBoldFont" id="myBtn">Deactivate Account</a> 
					</td>
					</tr></c:if>
				</table>
			</div>
</div></div></div>
<%@include file="footer.jsp"%>
</body>
</html>