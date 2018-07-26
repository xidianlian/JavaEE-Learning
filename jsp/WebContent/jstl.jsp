<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%-- c是别名 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--jsp标准标签库 (JSTL)--%>

<%--通用标签
set out remove
开发时基本不用
 --%>
<%--声明变量 --%>
<c:set var="num" value="10"></c:set>
<%-- --%>
<c:out value="${num }" default="默认值"></c:out>
<c:remove var="num"></c:remove>
<c:out value="${num }" default="aaa"></c:out>
</br>
<%--
	条件标签
	if choose(switch)
	没有else标签
 --%>
<c:set var="num" value="5"></c:set>
<c:if test="${num>3 }">
	ififif
</c:if>
<c:choose>
	<c:when test="${num==1 }">aaa</c:when>
	<c:when test="${num==3 }">bbb</c:when>
	<c:otherwise>ccc</c:otherwise>
</c:choose>
<%--
	foreach
 --%>
 <c:forEach var="i" begin="1" end="10" step="2">
 	</br>${i }
 </c:forEach>
 </br>
 <%
 	List<String> l=new ArrayList<String>();
 	l.add("a");
 	l.add("c");
 	l.add("d");
 	l.add("e");
 	request.setAttribute("list", l);
 %>
 <c:forEach items="${list }" var="it">
 	${it }
 </c:forEach>
 
 <table border="1">
 <tr>
 	<th>数据</th>
 	<th>索引</th>
 	<th>计数</th>
 	<th>是否第一个</th>
 	<th>是否第二个</th>
 </tr>
 <%--
 	varStatus属性，其实是一个对象
 	指向一个字符串，该字符串引用一个对象，map("vs",一个对象)
 	这个对象记录着当前遍历的元素的一些信息：
 	getIndex():返回索引，从0开始
 	getCount():返回计数，从1开始
 	isFirst():是否第一个元素
 	isLast():是否最后一个元素
  --%>
 <c:forEach items="${list }" var="it" varStatus="vs">
 	<tr style="background-color:${vs.index%2==0?'pink':'yellow'}">
 		<td>${it }</td>
 		<td>${vs.index }</td>
 		<td>${vs.count }</td>
 		<td>${vs.first }</td>
 		<td>${vs.last }</td>
 	</tr>
 </c:forEach>
 </table>
</body>
</html>