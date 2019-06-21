<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>ユーザー一覧画面</title>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.js"></script>
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
			<a href="./top" class="item">ホーム</a> <a href="./signup" class="item">ユーザー新規登録</a>
			<a href="./logout" class="item">ログアウト</a> <br />
		</div>
	</div>
	<div class="ui main container">
		<h2 class="ui header">ユーザー一覧画面</h2>
		<table class="ui compact fixed table">
			<thead>
				<tr>
					<th class="one wide">編集</th>
					<th class="three wide">ログインID</th>
					<th class="three wide">アカウント名</th>
					<th class="one wide">支店名</th>
					<th class="three wide">役職名</th>
					<th class="one wide">停止/復活</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userList}" var="user">
					<c:if test="${user.isWorking == 1}">
						<tr>
					</c:if>
					<c:if test="${user.isWorking == 0}">
						<tr class="negative">
					</c:if>
					<td><form:form modelAttribute="managementForm" action="edit"
							method="get">
							<form:hidden path="id" value="${user.id}" />
							<button type="submit" class="circular ui icon button">
								<i class="setting icon"></i>
							</button>
						</form:form></td>
					<td><c:out value="${user.loginId}" /></td>
					<td><c:out value="${user.name}" /></td>
					<td><c:out value="${user.branchName}" /></td>
					<td><c:out value="${user.positionName}" /></td>
					<td><c:if test="${loginUser.id != user.id}">
							<form:form modelAttribute="changeStatusForm"
								action="changeStatus">
								<c:if test="${user.isWorking == 1}">
									<form:hidden path="id" value="${user.id}" />
									<form:hidden path="isWorking" value="0" />
									<button type="submit" class="circular ui blue icon button"
										onClick="return showMessage('停止')">
										<i class="stop icon"></i>
									</button>
								</c:if>
								<c:if test="${user.isWorking == 0}">
									<form:hidden path="id" value="${user.id}" />
									<form:hidden path="isWorking" value="1" />
									<button type="submit" class="circular ui red icon button"
										onClick="return showMessage('復活')">
										<i class="forward icon"></i>
									</button>
								</c:if>
							</form:form>
						</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
