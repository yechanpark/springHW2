<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title> getRequestedCourses.jsp</title>
<style>
table, tr, td {
	border: 1px solid;
	border-collapse: collapse;
}

tr {
	text-align: center;
}
</style>
</head>
<body>
	수강신청 내역 조회
	<table>
		<tr>
			<td>과목코드
			<td>학년도	
			<td>학기
			<td>과목명
			<td>구분
			<td>이수학점
			<td>
		</tr>
		<c:forEach var="courses" items="${courses}">
			<tr>
				<td><c:out value="${courses.getCourseID()}"></c:out>
				<td><c:out value="${courses.getYear()}"></c:out>
				<td><c:out value="${courses.getSemester()}"></c:out>
				<td><c:out value="${courses.getCourseName()}"></c:out>
				<td><c:out value="${courses.getClassify()}"></c:out>
				<td><c:out value="${courses.getCourseGrade()}"></c:out>
				<td><a href="${pageContext.request.contextPath}/Request/doDeleteRequestedCourse?CourseID=${courses.getCourseID()}">취소</a>
			<tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}">go home</a>
</body>
</html>