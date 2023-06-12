<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.4.min.js"></script>
<script>
$(document).ready(function(){

});//ready end
</script>
</head>
<body>
<c:forEach items = "${filearray }" var="filename">
<h3>
<a href="/ocrresult?image=${filename}">${filename }</a>
<a href="/ocrresult?image=${filename}"><img src="/naverimages/${filename }" witdth="100" height="100"></a>
</h3>
</c:forEach>
</body>
</html>