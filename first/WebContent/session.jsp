<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Session.jsp</title>
</head>
<body>
<%
	String name=request.getParameter("name");
	session.setAttribute("name", name);
%>
<div>
<form id="form1"name="form1"method="post"action="result.jsp">
	<div>名字:</div>
	<input name="name" type="text" value="<%=name%>"/>
	<div>喜欢去的地方</div>
	<input name="like" type="text">
	<input type="submit" name="Submit" value="提交"/>
</form>
</div>
</body>
</html>