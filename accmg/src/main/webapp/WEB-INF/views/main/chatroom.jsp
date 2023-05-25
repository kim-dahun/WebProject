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
		<title>채팅방</title>
	</head>
	<body>
		<h1>대화방</h1>
		<main>
			<h2>상대 이름</h2>
			<div id="chatcontent">대화 내용 들어갈 곳</div>
		</main>
		<div>
		
		<label for="inputtext">내용</label>
		<input type="text" name="inputtext" id="inputtext" placeholder="여기에 할 말을 입력하세요." />
		<button id="btnsend" name="btnsend">전송</button>
		<button id="btnclose" name="btnclose">소켓 연결 해제</button>
		<button id="btnopen" name = "btnopen">소켓 연결</button>
		
		</div>
		
		
		
			<script src="../static/js/chatroom.js" />
		    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	</body>
</html>