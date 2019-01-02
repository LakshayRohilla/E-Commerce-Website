$(document).ready(function(){
	 $("#warningModal").modal('show');	
	if($("#sh").val()=="true"){
		 $("#myModal").modal({backdrop: "static"});
	}
	$("#myBtn").click(function(){
        $("#myModal").modal({backdrop: "static"}
        );
    });
});