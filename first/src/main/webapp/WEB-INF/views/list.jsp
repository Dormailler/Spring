<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

</body>
</html>