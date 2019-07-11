<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#wrapper{
	
		margin : 30px auto;
		width: 400px;
		border:1px solid black;
	
	}
	
</style>
</head>
<body>
	<div id="wrapper">
		<form action="./loginProcess.do" method="post">
			<h1>로그인</h1><br>
			ID : <input type="text" name="id"><br>
			PW : <input type="password" name="pw"><br>
			<input type="submit" value="로그인">
			<a href="./joinMemberPage.do">회원가입</a>
		
		</form>
	
	</div>
</body>
</html>