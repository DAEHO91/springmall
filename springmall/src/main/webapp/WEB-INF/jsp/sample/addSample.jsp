<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function()=>{
	$('#sampleId').focus();
	
	$('#add').click(function()=>{
	    if($('#sampleId').val()==""){
	        alert("INSERT ID");
	        $('#sampleId').focus();
	    }
	    if($('#samplePw').val()==""){
	    	alert("INSERT PW");
	    	$('#samplePw').focus();
	    }
	    if($('#sampleId').val().length >3 && $('#samplePw').val().length >3 ){
	    	$('#addform').submit();
	    }
	}
});
	
</script>
<title>ADD SAMPLE</title>

</head>
<br>
<br>
<h3>ADD SAMPLE DATA</h3>
<br>
<br>
<body>
	<form id="addform" class="form-inline" action="/sample/addSample" method="post" enctype="multipart/form-data">
		<input type="hidden" name="sampleNo" value="0"> 
		<label for="ID">SAMPLE ID : </label> 
		<input type="text" class="form-control" id="sampleId" name="sampleId"> 
		<label for="pwd">SAMPLE PW : </label> 
		<input type="text" class="form-control" id="samplePw" name="samplePw"> 
		<label for="file">FILE UPLOAD : </label> 
		<input type="file" class="form-control" id="multipartFile" name="multipartFile"> 
		<button id="add" class="btn btn-primary">add</button>
	</form>

</body>



</html>