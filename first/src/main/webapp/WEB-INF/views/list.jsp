<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% ArrayList<String> list = (ArrayList<String>)request.getAttribute("list"); 
for(String one : list){
	out.println("<h1>" + one + "</h1>");
}
%>
<hr>
<c:forEach items="${list }" var="data">
	<h1 style="color:blue">${data }</h1>
</c:forEach>
</body>
</html>
<!-- st3-jdk11+tomcat9 -> jstl1.2 -->
<!-- 이클립스-jdk17+tomcat10.1 -> jstl2.0(패키지명 변경) -->