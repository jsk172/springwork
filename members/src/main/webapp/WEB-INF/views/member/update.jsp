<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
<style>
	.content{margin-left: 30px;}
</style>
</head>
<body>
	<div class="content">
		<h2>회원수정</h2>
		<form action="/member/update" method="post">
			<p>
				<input type="text" name="email" value="${member.email}" readonly>
			</p>
			<p>
				<input type="text" name="password" placeholder="비밀번호">
			</p>
			<p>
				<input type="text" name="name" value="${member.name}" readonly>
			</p>
			<p>
				<input type="text" name="age" value="${member.age}" readonly>
			</p>
			<p>
				<input type="submit" value="수정">
				<a href="/member/delete?email=${member.email}">
					<button type="button" onclick="return confirm('정말로 삭제하시겠습니까?')">삭제</button>
				</a>
				<input type="reset" value="취소">
			</p>
		</form>
	</div>
</body>
</html>