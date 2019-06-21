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
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.js"></script>
<style>
.main.container {
	padding-top: 7em;
}
</style>
</head>
<body>
	<div class="ui fixed inverted menu">
		<div class="ui container">
			<p class="header item">掲示板サンプル</p>
			<a href="./top" class="item">ホーム</a> <a href="./logout" class="item">ログアウト</a>
		</div>
	</div>
	<div class="ui main text container">
		<h2 class="ui header">新規投稿画面</h2>
		<div class="ui segment">
			<form:form modelAttribute="postForm" class="ui form">
				<form:errors path="*" />
				<div class="eleven wide field">
					<form:label path="subject">件名</form:label>
					<form:input path="subject" />
				</div>
				<div class="field">
					<form:label path="text">本文</form:label>
					<form:textarea path="text" />
				</div>
				<div class="five wide field">
					<form:label path="category">カテゴリ</form:label>
					<form:input path="category" />
				</div>
				<button type="submit" class="ui primary labeled icon button">
					<i class="comment icon"></i> 投稿
				</button>
				<a href="./top" class="ui button">キャンセル</a>
			</form:form>
		</div>
	</div>
</body>
</html>
