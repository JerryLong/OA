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
    <title>部门列表</title>
    <%@include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 部门管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
            	<td width="150px">部门名称</td>
				<td width="150px">上级部门名称</td>
				<td width="200px">职能说明</td>
				<td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" >
			<s:iterator value="#depts">
			<tr class="TableDetail1 template">
				<td><a href="depertment_list.action?deptId=${deptId }">${deptName}</a>&nbsp;</td>
				<td>${deptUp.deptName}&nbsp;</td>
				<td>${description}&nbsp;</td>
				<td>
				<s:a onClick="return window.confirm('这将删除所有的下级部门，您确定要删除吗？')" action="depertment_delete?deptId=%{deptId}&deptUpId=%{deptUp.deptId}">删除</s:a>
				<s:a action="depertment_editPage?deptId=%{deptId}&deptUpId=%{deptUp.deptId}">修改</s:a>
				</td>
			</tr>
			</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
        	
           	 <s:a action="depertment_addPage.action?deptUpId=%{deptId}"><img src="style/images/createNew.png" /></s:a>
            	<a href="depertment_list.action?deptId=${updept }"><img src="style/blue/images/button/ReturnToPrevLevel.png" /></a>
        </div>
    </div>
</div>

<!--说明-->	
<div id="Description"> 
	说明：<br />
	1，列表页面只显示一层的（同级的）部门数据，默认显示最顶级的部门列表。<br />
	2，点击部门名称，可以查看此部门相应的下级部门列表。<br />
	3，删除部门时，同时删除此部门的所有下级部门。
</div>

</body>
</html>
