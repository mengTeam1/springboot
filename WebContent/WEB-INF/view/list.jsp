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
<table border="1">
	<tr>
	<td>编号</td>
	<td>姓名</td>
	<td>操作</td>
	</tr>
	
	<c:forEach items="${requestScope.staffList }" var="r">
	<tr>
	<td>${r.id }</td>
	<td>${r.getsName() }</td>
	<td><a href="javascript:void();" onclick="doClickDetail(${r.id },this)" class="detail">查看详情</a></td>
	</tr>
	
	
	</c:forEach>
	

</table>

<script src="/ajax_01/js/jquery-1.12.4.js"></script>
<script>

	




 function doClickDetail(sid,t){

	 //ajax发送请求
	if(window.XMLHttpRequest) {
		//1.创建引擎对象
		var xhr = new XMLHttpRequest();
		//2.打开连接，并发送请求
		xhr.open("POST", "/ajax_01/c/StaffAction?m=queryLinkById", true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
		xhr.send("id="+sid);
		//3.处理响应
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4) {
				if(xhr.status == 200) {
					var tx=xhr.responseText;
					var tr="<tr><td colspan='3'>"+tx+"<input type='button' value='取消' onclick='doCancel(this)'></td></tr>";
					$(t).parent().parent().after(tr);
				}
				
			}
			
			
		}

			
		
		
		
	}else{
		alert("请升级浏览器");
		
	} 

}	
function doCancel(t){
	$(t).parent().parent().remove();
	
}

</script>
</body>
</html>