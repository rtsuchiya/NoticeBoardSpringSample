<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>新規投稿画面</title>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.js"></script>
</head>
<body>
	<div class="ui container">
		<form:form modelAttribute="postForm" class="ui form">
			<h2 class="ui dividing header">新規投稿画面</h2>
			<div class="fields">
				<div class="two wide field">
					<h3 class="field">件名</h3>
				</div>
				<div class="five wide field">
					<form:input path="subject" class="field" />
					<form:errors path="subject" />
				</div>
				<div class="field">
					<label id="text">本文</label>
					<form:textarea path="text" />
					<form:errors path="text" />
				</div>
				<div class="field">
					<label id="category">カテゴリ</label>
					<form:input path="category" />
					<form:errors path="category" />
				</div>
				<input type="submit" value="投稿する" />
			</div>
		</form:form>
		<a href="./top">ホームへ戻る</a>
	</div>
</body>
</html>
