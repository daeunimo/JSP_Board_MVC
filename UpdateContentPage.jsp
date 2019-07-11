<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<form action="./updateContentProcess.do" method="post">
			제목 : <input type="text" name="title" value="${contentDTO.c_title }"><br>
			작성자 : ${sessionData.sessionNick }<br>
			내용 : <br>
			<textarea rows="20" cols="40" name="content">
			${contentDTO.c_content }
			</textarea>
			<input type="hidden" name="c_idx" value="${contentDTO.c_idx }">
			<br>
			<input type="submit" value="수정">
		</form>
	
	
	</div>
</body>
</html>