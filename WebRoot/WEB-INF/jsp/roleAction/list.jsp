<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>岗位列表</title>
<%@include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body style="margin: 0;overflow:hidden;">

	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="style/images/title_arrow.gif" /> 岗位管理
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<div id="MainArea">
		<table cellspacing="0" cellpadding="0"  >

			<!-- 表头-->
			<thead>
				<tr align="CENTER" valign="MIDDLE" id="TableTitle">
					<td width="200px">岗位名称</td>
					<td width="300px">岗位说明</td>
					<td width="200px">相关操作</td>
				</tr>
			</thead>

			<!--显示数据列表-->
			<tbody id="TableData" class="dataContainer"  >
				<s:iterator value="#roleList">
					<tr class="TableDetail1 template">
						<td>${name}&nbsp;</td>
						<td>${description}&nbsp;</td>
						<td><s:a onClick="return delConfirm()" action="role_delete?id=%{id}">删除</s:a> 
							<s:a action="role_editPage?id=%{id}">修改</s:a>
							<s:a action="role_setPrivilegePage?id=%{id}">设置权限</s:a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail">
			<div id="TableTail_inside">
				<s:a action="role_addPage"><img src="style/images/createNew.png" /></s:a>
			</div>
		</div>
	</div>
	<!-- 
  	<table>
	<tr>
		<td>${id}</td>
		<td>${name}</td>
		<td>${description}</td>
		<td>
		<s:a action="role_editPage?id=%{id}" >修改</s:a>
		</td>
		<td>
		<s:a action="role_delete?id=%{id}" onclick="return confirm('是否删除！')">删除</s:a><br/>
		</td>
	</tr>	
  	</table>
	<s:a action="role_addPage">增加岗位</s:a>
  	 -->
</body>
</html>
