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
	window.onload=function(){
		//1、获取XMLHttpRequest对象
		var xmlRequest=getXMLHttpRequest();
		
		//onreadystatechange 存储函数（或函数名），
		//每当 readyState 属性改变时，就会调用该函数
		xmlRequest.onreadystatechange=function(){
			//alert(xmlRequest.readyState);
			if(xmlRequest.readyState==4){
// 				alert(xmlRequest.status);
				if(xmlRequest.status==200){
				//服务器响应正常
					//responseText获取响应内容
					alert(xmlRequest.responseText);
				}
			}
		}
	
		//2、建立连接,第三个参数默认异步
		xmlRequest.open("get","${pageContext.request.contextPath}/Demo1Servlet");
		//3、发送请求
		xmlRequest.send(null);
	}
</script>
<body>
		
</body>
</html>