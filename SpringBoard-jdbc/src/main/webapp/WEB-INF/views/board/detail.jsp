<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="content">
		<h1>상세보기</h1>
			<table class="tbl_write">
				<tr>
					<td>
						<input type="text" name="boardTitle" value="${board.boardTitle}" readonly>
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="boardWriter" value="${board.boardWriter}" readonly>
					</td>				
				</tr>
				<tr>
					<td>
						<textarea rows="5" cols="50" name="boardContent" placeholder="글내용" readonly>${board.boardContent}</textarea>
					</td>				
				</tr>
				<tr>
					<td>
					<!-- 로그인한 사람만 수정/삭제 버튼 보이기  -->
					<c:if test="${board.boardWriter eq sessionId}">
						<a href="/board/update?id=${board.id}">
							<button>수정</button>
						</a>
						<a href="/board/delete?id=${board.id}" onclick="return confirm('정말로 삭제하시겠습니까?')">
							<button>삭제</button>
						</a>
					</c:if>
						<a href="/board/list"><button>목록</button></a>
					</td>
				</tr>				
			</table>		
	</div>
</body>
</html>