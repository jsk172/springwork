<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Members</title>
<style>
	.content{margin-left: 30px;}
</style>
</head>
<body>
	<div class="content">
		<c:choose>
			<c:when test="${empty sessionEmail}">
				<h2>Members Project</h2>
				<h4><a href="/member/join">회원가입</a></h4>
				<h4><a href="/member/login">로그인</a></h4>
			</c:when>
			<c:otherwise>
				<h2>Members Project</h2><h4>${sessionEmail}님 환영합니다</h4>
				<h4><button type="button" onclick="update()">내정보 수정</button></h4>
				<h4><button type="button" onclick="logout()">로그아웃</button></h4>
				<h4><button type="button" onclick="index()">Home</button></h4>
			</c:otherwise>
		</c:choose>
	</div>
	
<script>
	let index = function(){
		location.href = "/";
	}
	let logout = function(){
		location.href = "/member/logout";
	}
	let update = function(){
		location.href = "/member/update";
	}
</script>
</body>
</html>