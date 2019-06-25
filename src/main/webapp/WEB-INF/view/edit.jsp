<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>ユーザー編集画面</title>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.js"></script>
<script type="text/javascript">
	function showMessage(message) {
		return window.confirm("本当に" + message + "しますか？");
	}
</script>
<style>
.main.container {
	padding-top: 7em;
}

.ui.form .error.message {
	display: block !important;
}
</style>
</head>
<body>
	<div class="ui fixed inverted menu">
		<div class="ui container">
			<p class="header item">掲示板サンプル</p>
			<a href="./management" class="item">ユーザー一覧</a> <a href="./logout"
				class="item">ログアウト</a>
		</div>
	</div>
	<div class="ui main text container">
		<h2 class="ui header">ユーザー編集画面</h2>
		<div class="ui segment">
			<form:form modelAttribute="editForm" class="ui form">
				<form:errors path="*" class="ui error message" />
				<form:hidden path="id" value="${editUser.id}" />
				<div class="seven wide field">
					<form:label path="loginId">ログインID</form:label>
					<form:input path="loginId" value="${editUser.loginId}" />
				</div>
				<div class="seven wide field">
					<form:label path="password">パスワード</form:label>
					<form:password path="password" />
				</div>
				<div class="seven wide field">
					<form:label path="confirmPassword">パスワード(確認)</form:label>
					<form:password path="confirmPassword" />
				</div>
				<div class="five wide field">
					<form:label path="accountName">アカウント名</form:label>
					<form:input path="accountName" value="${editUser.accountName}" />
				</div>
				<c:if test="${loginUser.id != editUser.id}">
					<div class="three wide field">
						<form:label path="branchId">支店</form:label>
						<form:select path="branchId">
							<form:options items="${branchList}" itemLabel="name"
								itemValue="id" />
						</form:select>
					</div>
					<div class="five wide field">
						<form:label path="positionId">役職</form:label>
						<form:select path="positionId">
							<form:options items="${positionList}" itemLabel="name"
								itemValue="id" />
						</form:select>
					</div>
				</c:if>
				<c:if test="${loginUser.id == editUser.id}">
					<form:hidden path="branchId" value="${editUser.branchId}" />
					<form:hidden path="positionId" value="${editUser.positionId}" />
				</c:if>
				<button type="submit" onClick="return showMessage('編集')"
					class="ui primary labeled icon button">
					<i class="user plus icon"></i>編集
				</button>
				<a href="./management" class="ui button">キャンセル</a>
			</form:form>
		</div>
	</div>
</body>
</html>
