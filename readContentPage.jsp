<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		제목 : ${contentData.contentDTO.c_title}<br>
		작성자 : ${contentData.memberDTO.m_nick }<br>
		작성일 : ${contentData.contentDTO.c_writedate }<Br>
		내용 : <br>
		${contentData.contentDTO.c_content }<br><br>
		
		<a href="./boardPage.do">목록</a>
		<c:if test="${sessionData.sessionIdx == contentData.contentDTO.m_idx }">
			<a href="./updateContentPage.do?c_idx=${contentData.contentDTO.c_idx }">수정</a>
			<a href="./deleteContentProcess.do?c_idx=${contentData.contentDTO.c_idx }">삭제</a>
		</c:if>
		
	</div>
</body>
</html>