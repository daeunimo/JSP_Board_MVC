<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#wrapper{
		width: 600px;
		margin: 30px auto;
		border: 1px solid black;
	
	}


</style>
</head>
<body>
	<div id="wrapper">
		<h1>게시판</h1><br>
		<c:choose>
			<c:when test="${!empty sessionData }">
			${sessionData.sessionNick }님 환영합니다!<br>
			<a href="./logoutProcess.do">로그아웃</a><br>
			
			</c:when>
			<c:otherwise>
				비회원으로 접근하였습니다. <a href="./loginPage.do">로그인 페이지로...</a>
			</c:otherwise>		
		</c:choose>
		
		<table border="1">
			<tr><td>글 번호</td><td>제목</td><td>작성자</td><td>작성일</td><td>조회수</td></tr>
			<c:forEach var="contentData" items="${listContent }" >
				<tr>
					<td>${contentData.contentDTO.c_idx }</td>
					<td><a href="./readContentPage.do?c_idx=${contentData.contentDTO.c_idx }">
						${contentData.contentDTO.c_title }</a></td>
					<td>${contentData.memberDTO.m_nick }</td>
					<td>${contentData.contentDTO.c_writedate }</td>
					<td>${contentData.contentDTO.c_count }</td>
				</tr>
			</c:forEach>
		
		</table>
	
		<br>
		<c:if test="${!empty sessionData }">
			<a href="./writeContentPage.do">글 작성</a>
		</c:if>
	</div>
</body>
</html>