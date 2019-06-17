<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>ログイン画面</title>
</head>
<body>
	<form:form modelAttribute="loginForm">
		ログインID<form:input path="loginId" />
		<form:errors path="loginId" />
		<br />
		パスワード<form:password path="password" />
		<form:errors path="password" />
		<br />
		<input value="ログイン" type="submit" />
	</form:form>
</body>
</html>
