<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp" %>

	<div class="container">
	
	<c:forEach var="board" items="${boards}">
		<div class="card m-2">
			<div class="card-body">
				<h4 class="card-title">제목 적는 부분</h4>
				<a href="/board/${board.id}" class="btn btn-primary">상세보기</a>
			</div>
		</div>
		
	</c:forEach>

	<ul class="pagination justify-content-center">
		<li class="page-item"><a class="page-link" href="?{board.number -1}">Previous</a></li>
		<li class="page-item"><a class="page-link" href="?{board.number + 1 }">Next</a></li>
	</ul>

</div>
	
<%@ include file="layout/footer.jsp" %>








<!-- 
<div class="card m-3">
			<div class="card-body">
				<h4 class="card-title">제목 적는 부분</h4>
				<p class="card-text">내용적는 부분</p>
				<a href="#" class="btn btn-primary">상세보기</a>
			</div>
		</div>
		
		<div class="card m-3">
			<div class="card-body">
				<h4 class="card-title">제목 적는 부분</h4>
				<p class="card-text">내용적는 부분</p>
				<a href="#" class="btn btn-primary">상세보기</a>
			</div>
		</div> -->
