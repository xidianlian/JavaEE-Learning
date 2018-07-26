<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="cn.webrelax.www.Student"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Student stu=(Student)request.getAttribute("name");
		out.print(stu+"</br>");
		out.print(stu.getName());
	%>
	</br>
	<%--
		${name}等价于 pageContext.findAttribute("name"),
		查找name为key存放的值（对象），包括request,Session,application存的  
	--%>
	${name}</br>
	${name.name}<%-- 利用对象调用的getName()函数 --%>
	<%-- [] 的使用方法和.一样，但更强大 --%>
	</br>
	${list[0]}
	</br>
	${map['ans']}
	${map['test']}
	<br>
	${empty map }
	${empty list?"空":"list不为空" }
	
	
	
</body>
</html>