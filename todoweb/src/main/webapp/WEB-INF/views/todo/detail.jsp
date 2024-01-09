<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo 상세보기</title>
</head>
<body>
<div class="container-fluid">
	<jsp:include page="../layout/header.jsp"/>
	<!-- 본문 영역 -->
	<div class="row content">
		<div class="col">
			<div class="card">
				<div class="card-body">
					<div class="input-group mb-3">
						<span class="input-group-text">번호</span>
						<input type="text" name="tno" value="${todo.tno}" class="form-control" readonly>
					</div>
					<div class="input-group mb-3">
						<span class="input-group-text">할 일</span>
						<input type="text" name="title" value="${todo.title}" class="form-control" readonly>
					</div>
					<div class="input-group mb-3">
						<span class="input-group-text">작성자</span>
						<input type="text" name="writer" value="${todo.writer}" class="form-control" readonly>
					</div>
					<div class="my-4">
						<div class="float-end">
							<button class="btn btn-primary">수정</button>
							<button class="btn btn-secondary">목록</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../layout/footer.jsp"/>
</div>
<script>
	//목록
	let listBtn = document.querySelector(".btn-secondary")
	let page = "${pageRequestDTO.page}"
	listBtn.addEventListener("click", function(e){
		location.href = "/todo/paging?page=" + page;
	});
	//수정
	let ModifyBtn = document.querySelector(".btn-primary")
	let tno = '${todo.tno}';
	ModifyBtn.addEventListener("click", function(e){
		location.href = "/todo/update?tno=" + tno;
	});
	
</script>
</body>
</html>