<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- EL的11个隐式对象 --%>
<%--
pageContext(只有这个才是一个对象,可以操作request session application的数据) javax.servlet.jsp.PageContext
pageScope 
requestScope
sessionScope
applicationScope
param 获得表单传过来的参数等作用
paramValues 重名参数
header 一个请求消息头
headerValues 重名消息头
initParam web.xml中全局参数
cookie 
 --%>
	<%
		//pageContext.setAttribute("p", "pageContext",PageContext.PAGE_SCOPE);
		pageContext.setAttribute("p", "pageContext");
		
	
		//pageContext.setAttribute("p", "pageContext",PageContext.REQUEST_SCOPE);
		request.setAttribute("p", "request");
		
		//pageContext.setAttribute("p", "pageContext",PageContext.SESSION_SCOPE);
		session.setAttribute("p", "session");
	
		//pageContext.setAttribute("p", "pageContext",PageContext.APPLICATION_SCOPE);
		application.setAttribute("p", "application");
	%>
	${p}<%--pageContext.findAttribute("p"),顺序查找第一个key为“p”的 --%>
	</br>
	${pageContext.request.contextPath }<%--路径 --%>

	</br>
	${requestScope.p }
	${sessionScope.p }
	</br>
	</br>
	${param.username }<%--request.getParameter("username") --%>
	${param.hobby[0] }<%--表单没有写 --%>
	</br>
	</br>
	${header["User-agent"]}
	</br>
	</br>
	${cookie.JSESSIONID.value }
</body>
</html>