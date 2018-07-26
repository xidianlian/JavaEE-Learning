<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
		Student stu=new Student();
		stu.setName("lianweicheng");
		request.setAttribute("name", stu);
		
		
		List<String> li=new ArrayList<String>();
		li.add("aaa");
		li.add("bbb");
		li.add("ccc");
		request.setAttribute("list", li);
		
		Map<String,String> mp=new HashMap<String,String>();
		mp.put("ans","1");
		mp.put("trian","2");
		mp.put("test","3");
		
		request.setAttribute("map", mp);
		
		request.getRequestDispatcher("/EL1.jsp").forward(request, response);
	%>

</body>
</html>