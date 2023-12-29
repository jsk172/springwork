<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<c:if test="${empty sessionId }">
		<script>
			alert("로그인 후 이용 가능합니다.");
			location.href = "/user/login";
		</script>
	</c:if>
	<div id="content">
		<h1>글목록</h1>
		<div>
			${sessionId}님 환영합니다. &nbsp;&nbsp;&nbsp;
			<a href="/user/logout">로그아웃</a>
		</div>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardList}" var="board">
					<tr>
						<td><a href="/board?id=${board.id}">${board.id}</a></td>
						<td>${board.boardTitle}</td>
						<td>${board.boardWriter}</td>
						<td>${board.createTime}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a href="/board/write"><button>글쓰기</button></a>
		</div>
	</div>
</body>
</html>