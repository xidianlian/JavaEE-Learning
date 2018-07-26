<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	                     JSP四大域对象
ServletContext  application 作用范围：整个Web应用。
HttpServletRequest request  作用范围：整个请求链（请求转发也存在）。 
HttpSession session         作用范围：一次会话。
PageContext pageContext     作用范围：（页面范围）整个JSP页面，是四大作用域中最小的一个。

四大域通用方法
Object getAttribute(java.lang.String name)   获取数据
void setAttribute(java.lang.String name,java.lang.Object object)  保存数据 
void removeAttribute(java.lang.String name)     删除数据

pageContext:
	可以操作其他三个域对象的数据；
	可以创建其他的八个隐式对象（在普通类中可以通过PageContext获取其他隐式对象）
	另外：findAttribute(String name);方法
	自动从 pageContext->requst->sessopm->application查找,直到找到为止（范围：小->大）
 --%>
 
 <%
//  pageContext.setAttribute("who", "lianweicheng");//另一个页面不能得到这个值
	pageContext.setAttribute("who", "lianweicheng", PageContext.PAGE_SCOPE);
 	
//  request.setAttribute("age", "100");
	pageContext.setAttribute("age", "100", PageContext.REQUEST_SCOPE);
	
// 	session.setAttribute("sex", "男");
	pageContext.setAttribute("sex", "男", PageContext.SESSION_SCOPE);
	
// 	application.setAttribute("ok", "ok");
	pageContext.setAttribute("ok", "ok", PageContext.APPLICATION_SCOPE);
	
 	//request.getRequestDispatcher("/four_field_object2.jsp").forward(request, response);
 	//重定向request数据取不到
 	response.sendRedirect(request.getContextPath()+"/four_field_object2.jsp");
 %>
</body>
</html>