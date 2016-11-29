<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<p> <a href="${pageContext.request.contextPath}/Course/queryCoursesBySemester"> 학기별 이수 학점 조회 </a>
<p> <a href="${pageContext.request.contextPath}/Course/queryCoursesByClassify"> 이수 구분별 학점 조회 </a>
<p> <a href="${pageContext.request.contextPath}/Request/getRequestableCourses"> 수강 신청하기 </a>
<p> <a href="${pageContext.request.contextPath}/Request/getRequestedCourses"> 수강 신청 내역 조회 </a>

</body>
</html>