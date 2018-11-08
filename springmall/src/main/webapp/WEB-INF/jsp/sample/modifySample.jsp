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
$(document).ready(()=>{
	$('#sampleId').focus();
	
	$('#modify').click(function()=>{
	    if($('#sampleId').val()==""){
	        alert("INSERT ID");
	        $('#sampleId').focus();
	    }
	    
	    if($('#samplePw').val()==""){
	    	alert("INSERT PW");
	    	$('#samplePw').focus();
	    }
	}
	
});


</script>
<title>MODIFY SAMPLE</title>
</head>
<br><br>
<h3>MODIFY SAMPLE DATA</h3>
<br><br>
<body>
	<form class="form-inline" action="/sample/modifySample" method="post">
		<input type="hidden" name="sampleNo" value="${sample.sampleNo}">
		<label for="ID">SAMPLE ID : </label> 
		<input type="text" class="form-control" name="sampleId" value="${sample.sampleId}"> 
		<label for="pwd">SAMPLE PW : </label> 
		<input type="text" class="form-control" name="samplePw" value="${sample.samplePw}">
		<button id="modify" type="submit" class="btn btn-primary">Modify</button>
	</form>

</body>
</html>