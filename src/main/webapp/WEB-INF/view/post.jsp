<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>新規投稿画面</title>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.js"></script>
</head>
<body>
	<form:form modelAttribute="postForm">
		件名<form:input path="subject" />
		<form:errors path="subject" />
		<br />
		本文<form:textarea path="text" />
		<form:errors path="text" />
		<br />
		カテゴリ<form:input path="category" />
		<form:errors path="category" />
		<br />
		<input type="submit" value="投稿する" />
	</form:form>
	<a href="./top">ホームへ戻る</a>
</body>
</html>
