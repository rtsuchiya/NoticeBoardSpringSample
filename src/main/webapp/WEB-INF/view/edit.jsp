<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>新規投稿画面</title>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.js"></script>
</head>
<body>
	<form:form modelAttribute="editForm">
		<form:hidden path="id" value="${editUser.id}" />
		ログインID<form:input path="loginId" value="${editUser.loginId}" />
		<form:errors path="loginId" />
		<br />
		パスワード<form:password path="password" />
		<form:errors path="password" />
		<br />
		パスワード(確認)<form:password path="confirmPassword" />
		<form:errors path="confirmPassword" />
		<br />
		アカウント名<form:input path="accountName" value="${editUser.accountName}" />
		<form:errors path="accountName" />
		<br />
		<c:if test="${loginUser.id != editUser.id}">
		支店
			<form:select path="branchId">
				<form:options items="${branchList}" itemLabel="name" itemValue="id" />
			</form:select>
			<form:errors path="branchId" />
			<br />
		役職
			<form:select path="positionId">
				<form:options items="${positionList}" itemLabel="name"
					itemValue="id" />
			</form:select>
			<br />
		</c:if>
		<c:if test="${loginUser.id == editUser.id}">
			<form:hidden path="branchId" value="${editUser.branchId}" />
			<form:hidden path="positionId" value="${editUser.positionId}" />
		</c:if>
		<input type="submit" value="編集する" />
	</form:form>
	<a href="./management">ユーザー一覧へ戻る</a>
</body>
</html>
