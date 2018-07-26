<%-- 
	JSP指令是为JSP引擎而设计的，它们并不直接产生任何可见输出，而只是
	告诉引擎如何处理JSP页面中的其余部分。
	有page、include、taglib指令
	语法：
		<%@指令名 属性1=“属性值1” 属性2=“属性值2”%>
	在page指令中设置了errorPage,程序发生错误直接跳转到该页面
	y=y/0;
	contentType="text/html; charset=UTF-8"等同于response.setContextType("text/html; charset=UTF-8")
	contentType="text/html; charset=UTF-8"可不写，源码中已将设置了setContexType
	session可设置，默认为true，可查看源码 
	pageEncoding，在将jsp页面翻译为.java文件时，用什么编码,与jsp文件保存编码格式一致
	contentType="text/html; charset=UTF-8"
   
	
--%>
<%@ page language="java" 
 	pageEncoding="UTF-8"
 	contentType="text/html; charset=UTF-8"
    errorPage="/error.jsp"
    import="cn.webrelax.www.Student"
    session="true"
 %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%--表示服务器向浏览器发送文档时，告诉浏览器要接受一个html格式的文档，编码格式 --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
	
	//这里声明全局变量或函数声明，可以在
	//D:\Java\JavaEE_workspace\.metadata\.plugins\
	//org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\jsp\org\apache\jsp
	//查看底层代码,jsp本质就是servlet,.jsp--翻译--> .java --编译-->.class
	int x=10;
	int max(int a,int b)
	{
	   return a>b?a:b;
	}
	%>
	<!-- html注释，不安全，费流量，当有人在网页上查看源码时它会显示 -->
	<%-- jsp注释，安全，省流量 --%>
	<%
		int y=10;
		x++;y++;
		//y=y/0;
		out.print(x+" "+y);
	%>
	
	
	
	<%-- 静态包含，翻译成.java时合并两个文件成一个文件，尽量用静态 --%>
	<%@include file="/login.jsp"%>
	<%-- 动态包含，不合并两个文件，执行到此处才导入 --%>
<%-- 	<jsp:include page="/login.jsp"></jsp:include> --%>
	
	<%
		Student stu1=new Student();
		stu1.setName("tom");
		out.print(stu1.getName());
		//这句话和jsp:forward作用一样
		//request.getRequestDispatcher("/error.jsp").forward(request, response);
	%>
	<%--            jsp六个动作 (主要适用于前端人员开法发)               
		<jsp:include>包含
		<jsp:forward>请求转发
		<jsp:param>设置请求参数
		<jsp:useBeam>创建一个对象
		<jsp:setProperty>给指定的对象属性赋值
		<jsp:getProperty>取出指定对象的属性值
	 --%>
	<%--创建对象 --%>
	<jsp:useBean id="stu2" class="cn.webrelax.www.Student"></jsp:useBean>
	<%--设置对象属性值 给stu2对象name属性赋值--%>
	<jsp:setProperty property="name" name="stu2" value="jerry"/>
	<%--取出对象属性值 --%>
	<jsp:getProperty property="name" name="stu2"/>
	<%--请求转发 及参数传递--%>
	<%--http://localhost:8081/jsp/error.jsp?name=lian --%>
<%-- 	<jsp:forward page="/error.jsp"> --%>
<%-- 	<jsp:param value="lian" name="name"/> --%>
<%-- 	</jsp:forward> --%>

	<%--            jsp的九大内置(隐式)对象（查看java底层代码可以发现）                   --%>
	<%--
		request, javax.servlet.http.HttpServletRequest 存的数据一次请求有效（包括转发）,能用它尽量不用session
		response,javax.servlet.http.HttpServletResponse
		session, javax.servlet.http.HttpSession 由session="true"控制开关 存的数据一次会话中有效
		config,     javax.servlet.ServletConfig
		application,javax.servlet.ServletContext  存的数据整个应用都有效，作用域太大，尽量少用
		page,     javax.lang.Object  当前对象this
		exception,java.lang.Throwable  由isErrorPage="false"开关
		pageContext,javax.servlet.jsp.PageContext (重要) 它的对象能得到其他八个对象,作用范围：当前页面
		out,        javax.servlet.jsp.JspWriter 字符流输出，相当于printWriter
	 --%>
</body>
</html>