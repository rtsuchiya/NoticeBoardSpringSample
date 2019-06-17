<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="utf-8">
<title>トップ画面</title>
</head>
<body>
	<a href="./post">新規投稿</a>
	<a href="./signup">ユーザー新規登録</a>
	<a href="./management">ユーザー一覧</a>
	<br />

	<c:forEach items="${messageList}" var="message">
		件名<c:out value="${message.subject}" />
		<br />
		本文<c:out value="${message.text}" />
		<br />
		カテゴリ<c:out value="${message.category}" />
		<br />
		投稿日時<fmt:formatDate value="${message.createdAt}"
			pattern="yyyy年MM月dd日 HH:mm:ss" />
		<br />
	</c:forEach>
</body>
</html>
