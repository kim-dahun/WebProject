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
	<div class="card text-bg-secondary mb-3 card-title">
		<header>
		<h1 class="text-center fw-bold">나의 장부관리 사이트</h1>
		</header>
	</div>
		<main>
		<c:url var="mainpage" value="/main/main" />
		<form method="post" action="${ mainpage }">
		<div class="mb-3"> 
			<label class="col-sm-2 col-form-label" for="id">아이디</label>
			<input id="formGroupExampleInput" class="form-control" type="text" placeholder="ID 입력" name="id" id="id" required="required"/>
			</div>
			<div class="mb-3">
			<label class="col-sm-2 col-form-label" for="password">비밀번호</label>
			<input id="formGroupExampleInput2" class="form-control" type="password" placeholder="비밀번호 입력" name="password" id="password" required="required"/>
			</div>
			<div class="d-grid gap-2">
				
				<input class="btn btn-primary" type="submit" value="로그인" />
			</div>
		</form>
		</main>
		<nav>
			<ul class="my-2">
				<c:url var="signin" value="/user/signin" />
				<li class=" btn btn-outline-dark"><a href="${signin }">회원가입</a></li>
				<c:if test="${ not empty user.id }">
				<c:url var="logout" value="/user/logout"/>
				<li class="btn btn-outline-dark"><a href="${logout }">로그아웃</a></li>
				</c:if>
			</ul>
		</nav>
		    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	</body>
</html>