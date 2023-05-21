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
	<div>
	<header>
		<h1 class="text-center fw-bold">회원 가입</h1>
	</heaer>
	</div>
	<main>
		<c:url var="signin" value="/user/signin" />
		<form class="row g-3" action="${signin }" method="post">
			<div class="mb-3">
			<div class="mb-3">
			<label class="form-label my-2" for="id">아이디</label>
			<input class="form-control" type="text" name="id" placeholder="id를 입력하세요" required="required"/>
			</div>
			<div class="mb-3">
			<label class="form-label my-2" for="password">비밀번호</label>
			<input class="form-control" type="text" name="password" placeholder="비밀번호를 입력하세요" required="required"/>
			</div>
			<div class="mb-3">
			<label class="form-label my-2" for="name">이름</label>
			<input class="form-control" type="text" name="name" placeholder="이름을 입력하세요" required="required"/>
			</div>
			<div class="mb-3">
			<label class="form-label my-2" for="phone">전화번호</label>
			<input class="form-control" type="text" name="phone" placeholder="전화번호를 입력하세요" required="required"/>
			</div>
			<div class="mb-3">
			<label class="form-label my-2" for="email">이메일</label>
			<input class="form-control" type="email" name="email" placeholder="email을 입력하세요" required="required"/>
			</div>
			<div class="mb-3">
			<label class="form-label my-2" for="birthday">생년월일</label>
			<input class="form-control" type="date" name="birthday" required="required"/>
			</div>
			<div class="mb-3">
			<label class="form-label my-2" for="companycode">회사코드</label>
			<input class="form-control" type="text" name="companycode" placeholder="회사 코드를 입력하세요" required="required"/>
			</div>
			<div class="mb-3 my-3">
			<input class="form-control" type="submit" value="회원가입"/>
			</div>
			</div>
			
		</form>
	</main>
	
		    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	</body>
</html>