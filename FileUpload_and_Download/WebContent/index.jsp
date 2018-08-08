<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--
 上传文件必须为post方法提交
enctype:属性规定在发送到服务器之前应该如何对表单数据进行编码。
multipart/form-data:不对字符编码。在使用包含文件上传控件的表单时，必须使用该值

 -->
	<form  enctype="multipart/form-data"action="${pageContext.request.contextPath }/Servlet2"method="post">
		<input type="text" name="name"/></br></br>
		<input type="file" name="photo"/></br></br>
		<input type="submit" value="上传">		
	</form>
</body>
</html>