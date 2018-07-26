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
	Object who=pageContext.getAttribute("who");
	out.println(who);
	
	Object age=request.getAttribute("age");
	out.println(age);
	
	Object sex=session.getAttribute("sex");
	out.println(sex);
	
	Object ok=application.getAttribute("ok");
	out.println(ok);
%>
</body>
</html>