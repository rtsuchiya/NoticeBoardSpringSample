<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>新規投稿画面</title>
</head>
<body>
	<form:form modelAttribute="postForm">
		件名<form:input path="subject" />
		<br />
		本文<form:textarea path="text" />
		<br />
		カテゴリ<form:input path="category" />
		<br />
		<input type="submit" value="投稿する" />
	</form:form>
	<a href="./top">ホームへ戻る</a>
</body>
</html>
