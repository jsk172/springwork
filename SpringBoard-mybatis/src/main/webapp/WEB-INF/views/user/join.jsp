<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<div id="container">
		<section id="join">
			<h2>회원가입</h2>
			<form action="/user/join" method="post" name="userform">
				<fieldset>
					<ul>
						<li>
							<label>아이디</label> 
							<input type="text" id="userId" name="userId" placeholder="아이디" onblur="checkId()">
							<p id="check-result"></p>
						</li>
						<li>
							<label>비밀번호</label> 
							<input type="password" id="userPasswd" name="userPasswd" placeholder="비밀번호" required></li>
						<li>
							<label>이름</label> 
							<input type="text" id="userName" name="userName" placeholder="이름" required></li>
						<li>
							<label>나이</label> 
							<input type="text" id="userAge" name="userAge" placeholder="나이"></li>
						<li colspan="2">
							<input type="button" value="가입" onclick="checkUser()"> 
							<input type="reset" value="취소">
						</li>
					</ul>
				</fieldset>
			</form>
		</section>
	</div>
	<jsp:include page="../layout/footer.jsp" />
<script src="/resources/js/validation.js"/>
</body>
</html>