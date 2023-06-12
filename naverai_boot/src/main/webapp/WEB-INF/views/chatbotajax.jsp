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
				let bubbles = server.bubbles;
				for(let b in bubbles){
					//1. 기본(텍스트 / 텍스트 + url)  
					if(bubbles[b].type=='text'){
						$('#response').append("기본답변 : " + server.bubbles[b].data.description + "<br>");
						if(bubbles[b].data.url != null){
							$('#response').append("<a href=" + bubbles[b].data.url + ">" + server.bubbles[b].data.description + "</a>")
						}
					}else if(bubbles[b].type=='template'){ // 2. 이미지(이미지+url)
						if(bubbles[b].data.cover.type == 'image'){
							$('#response').append("<img src=" + bubbles[b].data.cover.data.imageUrl + " width = 200 height= 200 ><br>")
							if(bubbles[b].data.contentTable[0][0].data.data.action.data.url != null){
								let href = bubbles[b].data.contentTable[0][0].data.data.action.data.url;
								let link = bubbles[b].data.contentTable[0][0].data.title;
								$('#response').append('<a href = ' + href + '>' + link + '</a><br>');
							}
						}else if(bubbles[b].data.cover.type == 'text'){ // 3. 멀티링크(url)
							$('#response').append("멀티링크답변 : " + server.bubbles[b].data.cover.data.description + "<br>");
							for(let c in bubbles[b].data.contentTable){
								for(let d in bubbles[b].data.contentTable[c]){
									let link = bubbles[b].data.contentTable[c][d].data.title;
									let href = bubbles[b].data.contentTable[c][d].data.data.action.data.url;
									$('#response').append('<a href = ' + href + '>' + link + '</a><br>');
								}
							}
						}
					}

				} // for end
			}, // success end
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