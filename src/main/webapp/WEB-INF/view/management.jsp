<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>ユーザー一覧画面</title>
</head>
<body>
	<a href="./top">ホーム</a>
	<a href="./signup">ユーザー新規登録</a>
	<a href="./logout">ログアウト</a>
	<table>
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
				<td><form:form modelAttribute="changeStatusForm"
						action="changeStatus">
						<c:if test="${user.isWorking == 1}">
							<form:hidden path="id" value="${user.id}" />
							<form:hidden path="isWorking" value="0" />
							<input type="submit" value="停止" />
						</c:if>
						<c:if test="${user.isWorking == 0}">
							<form:hidden path="id" value="${user.id}" />
							<form:hidden path="isWorking" value="1" />
							<input type="submit" value="復活" />
						</c:if>
					</form:form></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
