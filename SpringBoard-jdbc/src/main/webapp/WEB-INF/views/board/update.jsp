<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="content">
		<h1>글 수정</h1>
		<form action="/board/update" method="post">
		<input type="hidden" name="id" value="${board.id}">
			<table class="tbl_write">
				<tr>
					<td>
						<input type="text" name="boardTitle" value="${board.boardTitle}">
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="boardWriter" value="${board.boardWriter}" readonly>
					</td>				
				</tr>
				<tr>
					<td>
						<textarea rows="5" cols="50" name="boardContent" placeholder="글내용">${board.boardContent}</textarea>
					</td>				
				</tr>
				<tr>
					<td>
						<button type="submit">수정</button>
						<a href="/board/list"><button type="button">목록</button></a>
					</td>
				</tr>				
			</table>		
		</form>
	</div>
</body>
</html>