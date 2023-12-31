<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<div id="container">
		<section id="memberList">
			<h2>회원목록</h2>
			<table class="tbl_join">
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>나이</th>
					<th>삭제</th>
				</tr>
				<c:forEach items="${userlist}" var="user">
					<tr>
						<td>${user.id}</td>
						<td><a href="/user?id=${user.id}">${user.userId}</a></td>
						<td>${user.userPasswd}</td>
						<td>${user.userName}</td>
						<td>${user.userAge}</td>
						<td>
							<a href="/user/delete?id=${user.id}"><button>삭제</button></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</section>
	</div>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>