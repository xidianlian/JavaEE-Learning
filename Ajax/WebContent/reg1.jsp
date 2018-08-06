<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script ty="text/javascript" src="${pageContext.request.contextPath}/js/myJS.js"></script>
</head>
<script type="text/javascript">
	function getXMLHttpRequest(){
		var xmlhttp;
		if (window.XMLHttpRequest)
		{// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp=new XMLHttpRequest();
		}
		else
		 {// code for IE6, IE5
			 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		 }
		return xmlhttp;
	}
	//另一种写法，验证用户名
	window.onload=function(){
		var nameElment=document.getElementById("username");
		nameElment.onblur=function(){
			var name=this.value;//this==nameElment;
			var xhr=getXMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4&&xhr.status==200){
					
					var msg=document.getElementById("msg");
					msg.innerHTML= "<font color='red'>"+xhr.responseText+"</font>";
				}
			}
			xhr.open("get","${pageContext.request.contextPath}/CheckNameServlet?username="+name);
			xhr.send(null);
		}
	}
</script>
<body>
		用户名：<input type="text" id="username" /><span id="msg"></span><br/>
		密码<input type="password" name="pwd"/><br/>
</body>
</html>