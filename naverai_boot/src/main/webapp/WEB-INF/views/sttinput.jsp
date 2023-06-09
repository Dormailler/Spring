<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.4.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>

</head>
<body>
<%
String[] languages = {"Kor","Eng","Jpn","Chn"};
String[] languages_names = {"한국어","영어","일본어","중국어"};
%>
<form action="sttresult" method="get">
	언어 선택 : <br>
	<%for(int i=0;i<languages.length; i++){ %>
	<input type=radio name="lang" value=<%=languages[i] %>><%=languages_names[i] %><br>
	<%}%>
	mp3파일선택 : <br>
	<select name="file">
	<c:forEach items="${filearray }" var="onefile">
		<option value="${onefile }">${onefile }
	</c:forEach>
	</select>
	<input type=submit value="텍스트로변환요청">
</form>
</body>
</html>