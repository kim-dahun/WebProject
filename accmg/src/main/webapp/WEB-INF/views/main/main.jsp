<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
		<title>Homepage</title>
	</head>
	<body>
	<header>
		<h1>MainPage</h1>
		</header>
		<div>${ user.id } 님 로그인을 환영합니다.</div>
		<nav>
			<ul class="my-2">	
				<c:if test="${ not empty user.id }">
				<c:url var="logout" value="/user/logout"/>
				<li class="btn btn-outline-dark"><a href="${logout }">로그아웃</a></li>
				</c:if>
			</ul>
		</nav>
		<div>
			<ul>
				<c:url var="subjectCreate" value="/main/sbinsert">
					<c:param name="userid" value="${ user.id }" />
				</c:url>
				<li><a href="${ subjectCreate }">수입/지출 계정 등록</a></li>
				<li>수입/지출 내역 등록</li>
				<li>수입/지출 내역보고서 </li>
				<li>수입/지출 리스트</li>
			</ul>
		</div>
		
		
		<main>
		</main>
		    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	</body>
</html>