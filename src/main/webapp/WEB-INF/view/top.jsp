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
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.js"></script>
</head>
<body>
	<div class="ui container">
		<a href="./post">新規投稿</a>
		<c:if test="${loginUser.positionId == 1}">
			<a href="./management">ユーザー一覧</a>
		</c:if>
		<a href="./logout">ログアウト</a> <br />

		<form:form modelAttribute="searchForm" method="get" class="ui form">
			<div class="two fields">
				<div class="field">
					<input type="date" name="startDate" value="${searchForm.startDate}" />
				</div>
				<div class="field">
					<input type="date" name="endDate" value="${searchForm.endDate}" />
				</div>
			</div>
			<div class="two fields">
				<div class="field">
					<form:input path="category" placeholder="category" />
				</div>
				<input type="submit" value="検索する" />
			</div>
		</form:form>

		<c:forEach items="${messageList}" var="message">
		件名<c:out value="${message.subject}" />
			<br />
		本文
<pre><c:out value="${message.text}" /></pre>
			<br />
		カテゴリ<c:out value="${message.category}" />
			<br />
		投稿者<c:out value="${message.userName}" />
			<br />
		投稿日時<fmt:formatDate value="${message.createdAt}"
				pattern="yyyy年MM月dd日 HH時mm分ss秒" />
			<br />
			<c:if test="${loginUser.id == message.userId}">
				<form:form modelAttribute="deleteMessageForm" action="deleteMessage">
					<form:hidden path="id" value="${message.id}" />
					<input type="submit" value="削除する" />
				</form:form>
			</c:if>

			<c:forEach items="${commentList}" var="comment">
				<c:if test="${message.id == comment.messageId}">
				コメント
				<div class="ui message">
<pre><c:out value="${comment.text}" /></pre>
						投稿者
						<c:out value="${comment.userName}" />
						<br /> 投稿日時
						<fmt:formatDate value="${comment.createdAt}"
							pattern="yyyy年MM月dd日 HH時mm分ss秒" />
					</div>
					<c:if test="${loginUser.id == comment.userId}">
						<form:form modelAttribute="deleteCommentForm"
							action="deleteComment">
							<form:hidden path="id" value="${comment.id}" />
							<input type="submit" value="削除する" />
						</form:form>
					</c:if>
				</c:if>
			</c:forEach>

			<form:form modelAttribute="commentForm" action="comment">
				<form:hidden path="messageId" value="${message.id}" />
				<form:textarea path="text" />
				<input type="submit" value="コメントする" />
			</form:form>
		</c:forEach>
	</div>
</body>
</html>
