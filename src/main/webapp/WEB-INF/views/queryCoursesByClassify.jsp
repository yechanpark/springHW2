<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>queryCoursesByClassify.jsp</title>
<style>
table, tr, td {
	border: solid 1px;
	border-collapse: collapse;
}

tr {
	text-align: center;
}
</style>
</head>
<body>
	구분별 조회
	<table>
		<tr>
			<c:forEach var="classifies" items="${classifies}">
			<td><c:out value="${classifies}"></c:out>
			</c:forEach>
			<td>총 이수학점
			
		</tr>

		<tr>
			<c:forEach var="classifyGrade" items="${classifyGrade}">
				<td><c:out value="${classifyGrade}"></c:out>
			</c:forEach>

			<td><c:out value="${totalGrade}"></c:out>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}">go home</a>
</body>
</html>