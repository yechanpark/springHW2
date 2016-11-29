<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>queryCoursesBySemester.jsp</title>
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
	학기별 조회
	<table>
		<tr>
			<td>수강년도
			<td>학기
			<td>이수학점
			<td>상세보기
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td><c:out value="${list.getYear()}"></c:out></td>
				<td><c:out value="${list.getSemester()}"></c:out></td>
				<td><c:out value="${list.getTotalGrade()}"></c:out></td>
				<td><a href="${pageContext.request.contextPath}/Course/queryCoursesBySemester/detail?year=${list.getYear()}&semester=${list.getSemester()}">링크</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}">go home</a>
</body>
</html>