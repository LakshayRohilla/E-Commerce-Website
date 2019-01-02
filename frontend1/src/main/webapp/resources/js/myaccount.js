$(document).ready(function(){
	$("#nameSave").hide();
	$("#addressSave").hide();
	$("#emailSave").hide();
	$("#mobileSave").hide();
	$("#nameBtn").click(function(){
		$("#nameField").prop( "disabled", false ).addClass("form-control").focus();
		$(this).hide();
		$("#nameSave").show();
	});
	$("#addressBtn").click(function(){
		$("#addressField").prop( "disabled", false ).addClass("form-control").focus();
		$(this).hide();
		$("#addressSave").show();
	});
	$("#emailBtn").click(function(){
		$("#emailField").prop( "disabled", false ).addClass("form-control").focus();
		$(this).hide();
		$("#emailSave").show();
	});
	$("#mobileBtn").click(function(){
		$("#mobileField").prop( "disabled", false ).addClass("form-control").focus();
		$(this).hide();
		$("#mobileSave").show();
	});
});