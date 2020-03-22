<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageName" value="${board.name} 글 생성" />
<%@ include file="../part/head.jspf"%>

<script>
	function submitAddForm(form) {
		form.title.value = form.title.value.trim();

		if (form.title.value.length == 0) {
			alert('제목을 입력해주세요.');
			form.title.focus();

			return false;
		}

		form.body.value = form.body.value.trim();

		if (form.body.value.length == 0) {
			alert('내용을 입력해주세요.');
			form.body.focus();

			return false;
		}

		form.submit();
	}
</script>

<div class="con">

	<form name="addForm" onsubmit="submitAddForm(this); return false;"
		action="./doWrite" method="POST">
		<input type="hidden" name="boardId" value="${board.id}">
		<div>
			<span>제목</span>
			<div>
				<input autocomplete="off" type="text" name="title"
					required="required" autofocus="autofocus" maxlength="30"
					placeholder="제목" />
			</div>
		</div>
		<div>
			<span> 내용 </span>
			<div>
				<textarea autocomplete="off" name="body"
					required="required" maxlength="500"
					placeholder="내용"></textarea>
			</div>
		</div>
		<div>
			<span>작성</span>
			<div>
				<input type="submit" value="작성" />
				<a class="btn" href="#" onclick="history.back();">취소</a>
			</div>
		</div>
	</form>
</div>

<%@ include file="../part/foot.jspf"%>