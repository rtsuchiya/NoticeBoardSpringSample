<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>ユーザー新規登録画面</title>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.js"></script>
</head>
<body>
	<form:form modelAttribute="signupForm">
		ログインID<form:input path="loginId" />
		<form:errors path="loginId" />
		<br />
		パスワード<form:password path="password" />
		<form:errors path="password" />
		<br />
		パスワード(確認)<form:password path="confirmPassword" />
		<form:errors path="confirmPassword" />
		<br />
		アカウント名<form:input path="accountName" />
		<form:errors path="accountName" />
		<br />
		支店
		<form:select path="branchId">
			<form:options items="${branchList}" itemLabel="name" itemValue="id" />
		</form:select>
		<form:errors path="branchId" />
		<br />
		役職
		<form:select path="positionId">
			<form:options items="${positionList}" itemLabel="name" itemValue="id" />
		</form:select>
		<br />
		<input value="登録する" type="submit" />
	</form:form>
	<a href="./management">ユーザー一覧へ戻る</a>
</body>
</html>
