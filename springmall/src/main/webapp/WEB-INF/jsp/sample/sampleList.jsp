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

<!-- 주석 설명의 가정은 11~20페이지 조회시, lastPage 41인 상황-->
<!-- startPage가 0인상황은 첫페이지만 해당되기때문에 그 외는 이전으로 미리가기 활성화 -->
	  		<c:if test="${startPage!=0}">
	    		<li class="page-item"><a class="page-link" href="/sample/sampleList?currentPage=${startPage-10}">Previous</a></li>
	    	</c:if>

<!-- lastPage(41) - startPage(10)+9 < 0 은 false이기때문에 실행되지않는다 -->
<!-- 만일 lastPage(41) - startPage(40)+9 <0은 true이기때문에 실행되고 마지막 페이지네이션에 불필요한 페이지네이션까지 출력되지않음 -->
<!-- otherwise로 빠지게되여 시작은 startPage(10),  끝은 startPage+9(19)까지 10개의 반복문을 실행한다-->
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
<!-- lastPage(41)-startPage(10)+10>=0 은 true.. Next페이지 활성화 -->
<!-- 만약에 lastPage(41) - startPage(40)+10>=0 은 false.. Next페이지 비활성화 -->
		 	<c:if test="${(lastPage-(startPage+10))>=0}">
		    	<li class="page-item"><a class="page-link" href="/sample/sampleList?currentPage=${startPage+10}">Next</a></li>
			</c:if>
	 	</ul>
	</div>
	

	<br>
	
	<a href="/sample/addSample">ADD</a>
</body>
</html>


		










		    