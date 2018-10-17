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
部门：<select id="sel" onchange="onchangeName()">
<c:forEach items="${list }" var="l">
	<option value="${l.bmName }">${l.bmName }</option>
</c:forEach>
</select>

员工：<select id="yg" onchange="">
<option >请选择</option>
</select>

</body>
<script src="/ajax_01/js/jquery-1.12.4.js"></script>
<script>


		function onchangeName(){
			var name=$("#sel").val();
			
			$.ajax({
				url:"/ajax_01/c/bmAction?m=queryByLink",
				type: "post",	
				data:{
					name:name,
				},
				dataType:"json",
				"success":function(res){
					
					$("#yg").html("");
					$.each(res.list,function(i,obj){
						var option="<option>"+obj.sName+"</option>";
						
						$("#yg").append(option);
						
					})
					
				}
			});
			
			
		}


</script>

</html>