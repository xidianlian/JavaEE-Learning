<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>result.jsp</title>
<style type="text/css">
 #id1{
 	margin-left:50%;
 	width:500px;
 	height:400px;
 	border:1px solid red;
 }

</style>

</head>
<body>
<%
	String like=request.getParameter("like");
	String name=session.getAttribute("name").toString();
	
%>
<div style=""  id="id1">
	
	<div class="classname">名字:</div>
	<input name="name" type="text" value="<%=name%>"/>
	<div>喜欢去的地方</div>
	<input name="like" type="text"value="<%=like%>">
	

</div>
</body>
</html>