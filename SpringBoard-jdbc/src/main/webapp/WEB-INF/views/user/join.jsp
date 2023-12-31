<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="content">
		<h1>회원가입</h1>
		<form action="/user/join" method="post">
			<table class="tbl_join">
				<tr>
					<td>
						<label>아이디</label>
						<input type="text" name="userId" placeholder="아이디">
					</td>
				</tr>
				<tr>
					<td>
						<label>비밀번호</label>
						<input type="password" name="userPasswd" placeholder="비밀번호">
					</td>				
				</tr>
				<tr>
					<td>
						<label>이름</label>
						<input type="text" name="userName" placeholder="이름">
					</td>				
				</tr>
				<tr>
					<td>
						<label>나이</label>
						<input type="text" name="userAge" placeholder="나이">
					</td>				
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="가입">
						<input type="reset" value="취소">
					</td>				
				</tr>				
			</table>		
		
		</form>
	</div>
</body>
</html>