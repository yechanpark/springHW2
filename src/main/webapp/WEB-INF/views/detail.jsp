<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>datal.jsp</title>
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
	<table>
		<tr>
			<td>교과목 코드
			<td>수강년도
			<td>학기
			<td>교과목명
			<td>구분
			<td>이수학점
		<tr>
			<c:forEach var="course" items="${course}">
				<tr>
					<td><c:out value="${course.getCourseID()}"></c:out>
					<td><c:out value="${course.getYear()}"></c:out>
					<td><c:out value="${course.getSemester()}"></c:out>
					<td><c:out value="${course.getCourseName()}"></c:out>
					<td><c:out value="${course.getClassify()}"></c:out>
					<td><c:out value="${course.getCourseGrade()}"></c:out>
				</tr>
			</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}">go home</a>
</body>
</html>