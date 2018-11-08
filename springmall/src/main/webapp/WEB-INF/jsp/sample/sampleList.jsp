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
	
	<c:if test="${0 < currentPage}">
		<a href="/sample/sampleList?currentPage=${currentPage-1}">이전페이지</a>
	</c:if>
	현재 페이지 ${currentPage+1}
	<c:if test="${currentPage < lastPage}">
		<a href="/sample/sampleList?currentPage=${currentPage+1}">다음페이지</a>
	</c:if>
	
	<br>
	
	<c:set var ="num" value="0"/>
	<c:forEach var="i" begin="0" end="${lastPage}">
		<a href="/sample/sampleList?currentPage=${i}">${i+1}</a>
	</c:forEach>
	
	<br>
	
	<a href="/sample/addSample">ADD</a>
</body>
</html>