<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTTYPE html>
<html>
<head>
<meta charset="gb2312">
<meta charset="utf-8">
<title>table属性</title>
<style type="text/css">
	table{
		background:#99cc00;
		border:2px solid #000000;
		width:500px;
		margin:0 auto;
		text-align:center;
		/*表示将表格的边框合并*/
		border-collapse:collapse;

	}
	tr,td,th {
		border:2px solid #000000;
		line-height:30px;
	}
	tr.te{
		background-color:#66cc66;
	}
</style>
</head>
<table>
	<caption><h1>梁山英雄榜</h1></caption>
	<tr class="te">
		<th width="20%" >编号</th>
		<th width="20%" >姓名</th>
		<th width="60%">内容</th>
	</tr>
	<tbody>
		<tr>
		<td>001</td>
		<td>宋江</td>
		<td>及时雨</td>
		<tr>
		<tr>
		<td>002</td>
		<td>吴用</td>
		<td>智多星</td>
		<tr>
	</tbody>
</table>
</html>