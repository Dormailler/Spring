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
	$('input:button').on('click',function(){
		$('#response').append("질문 : " + $('#request').val() + "<br>");
		$.ajax(
		{	
			url : "/chatbotajaxprocess",
			data : {"request" : $('#request').val(), "event" : $(this).val()},
			type : 'get',
			dataType : 'json',
			success : function(server){
					$('#response').append("답변 : " + server.bubbles[0].data.description + "<br>");
			},
			error : function(e){
				alert(e);
			}
			
		});
	});
});
</script>

</head>
<body>

질문 : <input type=text id="request">
<input type=button value="답변" name="event">
<input type=button value="웰컴메시지" name="event">
<br>
대화내용 : <div id="response" style="border:2px solid aqua"></div>

</body>
</html>