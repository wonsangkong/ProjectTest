<%@page import="com.mvc.project.model.vo.CarryProject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CarryProject project = (CarryProject)request.getAttribute("project");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>캐리펀딩 프로젝트 게시판이 들어가는 글 입니다.</h1>
	<%= project.getProjectNo() %> <br>
	<%= project.getUserId() %> <br>
	<%= project.getProjectContent() %> <br>
	
</body>
</html>