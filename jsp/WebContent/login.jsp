<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String msg=(String)request.getAttribute("msg");
		if(msg!=null)
			out.print(msg);
		
	%>
	<form action="/jsp/DoLogin"method="get">
	用户名：<input type="text"name="username">
	密码：<input type="password"name="password">
	<input type="submit"value="登录">
	</form>
</body>
</html>