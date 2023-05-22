<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>나의 장부 관리</title>
</head>
<body>
	<header>
		<h1>장부 관리 계정 등록 페이지</h1>
	</header>
	<main>
		<div> <!-- 계정 과목 등록할 때 수입인지 지출인지 선택하고 그 밑에 계정명 등록 밑 순번 설정 -->
			<form action="/main/sbinsert" method="get">
				<input type="radio" name="type" value="income" id="income" />
				<input type="radio" name="type" value="pay" id="pay" />
			</form>
		</div>		

	</main>
</body>
</html>