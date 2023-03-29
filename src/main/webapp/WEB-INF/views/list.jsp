<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.dto.Dept" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Dept 테이블 목록보기</h1>
<table border = '1'>
	<tr>
		<th>부서번호</th>
		<th>부서명</th>
		<th>부서위치</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
<c:forEach items="${allData}" var="dto">
	<tr>
		<td>${dto.deptno}</td>
		<td>${dto.dname }</td>
		<td>${dto.loc }</td>
		<td><a href="deptDelete?deptno=${dto.deptno}">삭제</a></td>
		<td><a href="deptUpdateForm?deptno=${dto.deptno}">수정</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>