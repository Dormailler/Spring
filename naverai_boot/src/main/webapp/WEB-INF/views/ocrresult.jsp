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
	let json = JSON.parse('${ocrresult }'); // String --> JSON 객체 변환 json.변수명
	$("#output").html(JSON.stringify(json)); // JSON --> String 변환 {'변수명':'값..'}

	let mycanvas = document.getElementById("ocrcanvas");
	let mycontext = mycanvas.getContext("2d");
	let myimage = new Image();
	myimage.src = "/naverimages/${param.image}";
	
	myimage.onload = function(){
		if(myimage.width > mycanvas.width){
			mycanvas.width = myimage.width;
		}
		mycontext.drawImage(myimage,0,0,myimage.width,myimage.height);
		
		//이미지 글씨 박스화
		let fieldlist = json.images[0].fields;
		for(let i in fieldlist){
			if(fieldlist[i].lineBreak == true){
				$('#output2').append(fieldlist[i].inferText + "<br>");	
			}else{
				$('#output2').append(fieldlist[i].inferText + "&nbsp;");	
			}
			var x= fieldlist[i].boundingPoly.vertices[0].x;
			var y= fieldlist[i].boundingPoly.vertices[0].y;
			var width = fieldlist[i].boundingPoly.vertices[1].x - x;
			var height = fieldlist[i].boundingPoly.vertices[2].y - y;
			
			mycontext.strokeStyle = "blue";	
			mycontext.lineWidth = 2;
			mycontext.strokeRect(x,y,width,height);
		}
		
		
	}  
});
</script>

</head>
<body>
<%-- <h3>${ocrresult }</h3> --%>
<div id="output" style="border:2px solid orange"></div>
<div id="output2" style="border:2px solid green"></div>
<canvas id="ocrcanvas" style ="border:2px solid silver" width ="500" height="500"></canvas>
</body>
</html>