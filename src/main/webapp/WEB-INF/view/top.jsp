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
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.js"></script>
<style>
.main.container {
	padding-top: 7em;
}
</style>
<script type="text/javascript">
	function showMessage(message) {
		return window.confirm("本当に" + message + "しますか？");
	}
</script>
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
			<a href="./post" class="item">新規投稿</a>
			<c:if test="${loginUser.positionId == 1}">
				<a href="./management" class="item">ユーザー一覧</a>
			</c:if>
			<a href="./logout" class="item">ログアウト</a> <br />
		</div>
	</div>
	<div class="ui main text container">
		<div class="ui attached message">投稿検索</div>
		<form:form modelAttribute="searchForm" method="get"
			class="ui form attached fluid segment">
			<div class="three fields">
				<div class="five wide field">
					<label id="startDate">開始日</label> <input type="date"
						name="startDate" id="startDate" value="${searchForm.startDate}" />
				</div>
				<div class="five wide field">
					<label id="startDate">開始日</label> <input type="date" name="endDate"
						id="endDate" value="${searchForm.endDate}" />
				</div>
				<div class="five wide field">
					<form:label path="category">カテゴリ</form:label>
					<form:input path="category" />
				</div>
			</div>
			<button type="submit" class="ui primary labeled icon button">
				<i class="search icon"></i>検索
			</button>
		</form:form>
		<div class="ui segment">
			<c:forEach items="${messageList}" var="message">
				<div class="ui message">
					<div class="header">
						<c:out value="${message.subject}" />
					</div>
					<p>
					<pre>
						<c:out value="${message.text}" />
					</pre>
					</p>
					<br /> カテゴリ
					<c:out value="${message.category}" />
					<br /> 投稿者
					<c:out value="${message.userName}" />
					<br /> 投稿日時
					<fmt:formatDate value="${message.createdAt}"
						pattern="yyyy年MM月dd日 HH時mm分ss秒" />
					<br />
					<c:if test="${loginUser.id == message.userId}">
						<form:form modelAttribute="deleteMessageForm"
							action="deleteMessage">
							<form:hidden path="id" value="${message.id}" />
							<input type="submit" value="削除する"
								onClick="return showMessage('削除');" />
						</form:form>
					</c:if>
				</div>
				<c:forEach items="${commentList}" var="comment">
					<c:if test="${message.id == comment.messageId}">
						<div class="ui message">
							コメント
							<p>
							<pre>
								<c:out value="${comment.text}" />
							</pre>
							</p>
							投稿者
							<c:out value="${comment.userName}" />
							<br /> 投稿日時
							<fmt:formatDate value="${comment.createdAt}"
								pattern="yyyy年MM月dd日 HH時mm分ss秒" />
							<c:if test="${loginUser.id == comment.userId}">
								<form:form modelAttribute="deleteCommentForm"
									action="deleteComment">
									<form:hidden path="id" value="${comment.id}" />
									<input type="submit" value="削除する"
										onClick="return showMessage('削除');" />
								</form:form>
							</c:if>
						</div>
					</c:if>
				</c:forEach>

				<form:form modelAttribute="commentForm" action="comment">
					<form:hidden path="messageId" value="${message.id}" />
					<form:textarea path="text" />
					<input type="submit" value="コメントする" />
				</form:form>
			</c:forEach>
		</div>
	</div>
</body>
</html>
