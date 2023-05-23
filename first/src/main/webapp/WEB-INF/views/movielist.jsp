<%@page import="java.util.Set"%>
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
<h1>영화예약폼</h1>
<form action="moviereserve">
아이디<input type=text name="memberid"><br>
암호<input type=password name="pw"><br>
나이<input type="number" name="age"><br>
<select multiple name="mymovielist">
<c:forEach items = "${movielist }" var="movie">
<option>${movie }</option>
</c:forEach>
</select>
<input type=submit value="영화신청">
</body>
</html>