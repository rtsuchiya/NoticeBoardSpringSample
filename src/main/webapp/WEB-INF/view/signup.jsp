<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>ユーザー新規登録画面</title>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.js"></script>
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
			<a href="./management" class="item">ユーザー管理</a> <a href="./logout"
				class="item">ログアウト</a>
		</div>
	</div>
	<div class="ui main text container">
		<h2 class="ui header">ユーザー新規登録画面</h2>
		<div class="ui segment">
			<form:form modelAttribute="signupForm" class="ui form">
				<form:errors path="*" class="ui error message" />
				<div class="seven wide field">
					<form:label path="loginId">ログインID</form:label>
					<form:input path="loginId" />
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
					<form:input path="accountName" />
				</div>

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

				<button type="submit" class="ui primary labeled icon button">
					<i class="user plus icon"></i> 登録
				</button>
				<a href="./management" class="ui button">キャンセル</a>
			</form:form>
		</div>
	</div>
</body>
</html>
