<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SampleList</title>
<!-- bootStrap CDN -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  
<!--  jquery CDN -->
</head>

<body>
	<h1>SampleList</h1>
	

	
	<c:if test="${LOGINID == null}">
	<form action="/sample/login" method="post">
		<input type="hidden" name="sampleNo" value="1">
		<input type="text" name="sampleId" placeholder="ID">
		<input type="password" name="samplePw" placeholder="PW">
		<button type="submit">LOGIN</button>
	</form>
	</c:if>
	<c:if test="${LOGINID != null}">
		${LOGINID}!! LOGIN <br>
		<a href="/sample/logout">LOGOUT</a>
	</c:if>
	<table class="table table-hover">
		<thead>
			<tr>
				<td>SAMPLE NO</td>
				<td>SAMPLE ID</td>
				<td>SAMPLE PW</td>
				<td>DELETE</td>
				<td>UPDATE</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sample" items="${sampleList}">
			<tr>
				<td>${sample.sampleNo}</td>
				<td>${sample.sampleId}</td>
				<td>${sample.samplePw}</td>
				<td><a href="/sample/removeSample?sampleNo=${sample.sampleNo}">DELETE</a></td>
				<td><a href="/sample/modifySample?sampleNo=${sample.sampleNo}">UPDATE</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

<div class="container">          
  	<ul class="pagination">
  		<c:if test="${startPage!=0}">
    		<li class="page-item"><a class="page-link" href="/sample/sampleList?currentPage=${startPage-10}">Previous</a></li>
    	</c:if>
    	
    	<c:choose>
    		<c:when test="${lastPage-(startPage+9)<0}">
			    <c:forEach var="i" begin="${startPage}" end="${startPage+(lastPage-startPage)}">
			    	<li class="page-item"><a class="page-link" href="/sample/sampleList?currentPage=${i}">${i+1}</a></li>
			    </c:forEach>
		    </c:when>
			<c:otherwise>
				<c:forEach var="i" begin="${startPage}" end="${startPage+9}">
			    	<li class="page-item"><a class="page-link" href="/sample/sampleList?currentPage=${i}">${i+1}</a></li>
			    </c:forEach>
			</c:otherwise>
		</c:choose>
	    
	 	<c:if test="${(lastPage-(startPage+10))>=0}">
	    	<li class="page-item"><a class="page-link" href="/sample/sampleList?currentPage=${startPage+10}">Next</a></li>
		</c:if>
 	</ul>
</div>
	

	<br>
	
	<a href="/sample/addSample">ADD</a>
</body>
</html>