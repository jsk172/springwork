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
<script>
	let checkUser = function(){
		let form = document.userform;
		let userId = document.getElementById("userId").value;
		let userPasswd = document.getElementById("userPasswd").value;
		let userName = document.getElementById("userName").value;
		let userAge = document.getElementById("userAge").value;
		
		let regPasswd1 = /[0-9]+/; //숫자
		let regPasswd2 = /[a-zA-Z]+/;//영문자
		let regPasswd3 = /[-~!@#$%^&*()]+/;//특수문자
		let regName = /^[가-힣]+$/; //한글만		
		
		if(userId.length<4 || userId.length>15){
			alert("아이디는 4자이상 15자까지 입력해주세요.");
			document.getElementById("userId").select();
			return false;
		}else if(userPasswd.length<8 || !regPasswd1.test(userPasswd) || !regPasswd2.test(userPasswd) || !regPasswd3.test(userPasswd)){
			alert("비밀번호는 영문자, 숫자, 특수문자 포함 8자 이상 입력해주세요.");
			document.getElementById("userPasswd").select();
			return false;
		}else if(!regName.test(userName)){ //useName이 정규표현식에 일치하지 않으면
			alert("이름은 한글로 입력해주세요.");
			document.getElementById("userName").select();
			return false;
		}else if(isNaN(userAge) || userAge == ""){
			alert("나이는 숫자로 입력해주세요.");
			document.getElementById("userAge").select();
			return false;
		}else{
			form.submit();
		}
	} //checkUser
	/*
		ID 중복검사 순서
		1. 아이디와 입력값 가져오기
		2. 입력값을 서버에 전송하고 중복된 아이디가 있는지 확인
	*/
	let checkId = function(){
		let userId = document.getElementById("userId").value;
		console.log(userId);
		
		$.ajax({
			//요청 방식: post, url://user/checkuserid, 데이터 : userId
			type: "post",
			url:"/user/checkuserid",
			data:{"userId": userId},
			//서버에서 응답 - 성공과 실패
			success: function(response){
				console.log(response);
			},
			error: function(error){
				console.log("에러발생 :", error);
			}
		})
	} //checkId
</script>
</body>
</html>