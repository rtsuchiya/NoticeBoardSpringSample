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
	<div class="ui main text container">
		<h2 class="ui header">ユーザー一覧画面</h2>
		<table class="ui celled striped table">
			<tr>
				<th>編集</th>
				<th>ログインID</th>
				<th>アカウント名</th>
				<th>支店名</th>
				<th>役職名</th>
				<th>停止/復活</th>
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td><form:form modelAttribute="managementForm" action="edit"
							method="get">
							<form:hidden path="id" value="${user.id}" />
							<input type="submit" value="編集" />
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
									<input type="submit" value="停止"
										onClick="return showMessage('停止')" />
								</c:if>
								<c:if test="${user.isWorking == 0}">
									<form:hidden path="id" value="${user.id}" />
									<form:hidden path="isWorking" value="1" />
									<input type="submit" value="復活"
										onClick="return showMessage('復活')" />
								</c:if>
							</form:form>
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
