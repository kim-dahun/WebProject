<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ��� ����</title>
</head>
<body>
	<header>
		<h1>��� ���� ���� ��� ������</h1>
	</header>
	<main>
		<div> <!-- ���� ���� ����� �� �������� �������� �����ϰ� �� �ؿ� ������ ��� �� ���� ���� -->
			<form action="/main/sbinsert" method="get">
				<input type="radio" name="type" value="income" id="income" />
				<input type="radio" name="type" value="pay" id="pay" />
			</form>
		</div>		

	</main>
</body>
</html>