<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>ログイン画面</title>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.js"></script>
</head>
<body>
	<div class="ui container">
		<h2 class="ui dividing header">ログイン画面</h2>
		<form:form modelAttribute="loginForm" class="ui form">
			<form:errors path="*" />
			<div class="fields">
				<label class="three wide field">ログインID</label>
				<form:input path="loginId" class="five wide field" />
			</div>
			<br />
			<div class="fields">
				<label class="three wide field">パスワード</label>
				<form:password path="password" class="five wide field" />
				<br />
			</div>
			<input value="ログイン" type="submit" />
		</form:form>
	</div>
</body>
</html>
