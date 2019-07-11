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
		<form action="./joinMemberProcess.do" method="post">
			<h1>회원가입</h1><br>
			ID : <input type="text" name="id"><br>
			PW : <input type="text" name="pw"><br>
			NICK : <input type="text" name="nick"><br>
			Address : <input type="text" name="address"><br>
			Phone : <input type="text" name="phone"><br>
			<input type="submit" value="회원가입"><br>
		
		</form>
		
	
	
	
	</div>





</body>
</html>