<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<div id="container">
		<section id="boardlist">
			<h2>글목록</h2>
			<table class="tbl_list">
				<thead>
					<tr>
						<td>글번호</td>
						<td>글제목</td>
						<td>글쓴이</td>
						<td>작성일</td>
						<td>조회수</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${boardList}" var="board">
						<tr>
							<td>${board.id}</td>
							<td><a href="/board?id=${board.id}">${board.boardTitle}</a></td>
							<td>${board.userId}</td>
								<c:choose>
									<c:when test="${empty board.updateTime}">
										<td>작성일: <fmt:formatDate value="${board.createdTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									</c:when>
									<c:otherwise>
										<td>수정일: <fmt:formatDate value="${board.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									</c:otherwise>
								</c:choose>
							<td>${board.hit}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- 글쓰기 버튼 -->
			<div>
				<a href="/board/write"><button>글쓰기</button></a>
			</div>
		</section>
	</div>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>