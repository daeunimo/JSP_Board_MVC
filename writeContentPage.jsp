<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		#wrapper{
			margin: 30px auto;
			width: 600px;
			border: 1px solid black;
		
		}
	</style>
</head>
<body>
	<div id="wrapper">
		<form action="./writeContentProcess.do" method="post">
			<h1>글쓰기</h1><br>
			작성자 : ${sessionData.sessionNick }<br>
			제목 : <input type="text" name="title"><br>
			내용 : <br>
			<textarea rows="20" cols="40" name="content"></textarea>
			<input type="submit" value="글 작성">
		</form>
	</div>
</body>
</html>