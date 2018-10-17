<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="div"></div>



</body>
<script src="/ajax_01/js/jquery-1.12.4.js"></script>

<script>
	$(function(){
		//ajax发送请求
		if(window.XMLHttpRequest){
			//1.创建引擎对象
			var xhr=new XMLHttpRequest();
			//2.打开链接，发送请求
			xhr.open("get","/ajax_01/c/StaffAction?m=queryAll",true);
			xhr.send(null);
			
			//3.处理响应
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4){
					var rs=xhr.responseText;
					//数据dom渲染
					$("#div").html(rs);
					
				}
			}
			
		}else{
			alert("请更换浏览器");
			
			
		}
		
	
		
		
	});


</script>
</html>