<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
    <title>版块列表</title>
    <%@include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body>
  
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 版块管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="250px">版块名称</td>
                <td width="300px">版块说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer"  >
        <s:iterator value="forumList" status="stat">
			<tr class="TableDetail1 template">
        		<s:hidden name="#{id}"></s:hidden>
				<td>${name}&nbsp;</td>
				<td>${description}&nbsp;</td>
				<td><a onClick="return delConfirm()" href="forumManage_delete?id=${id}">删除</a>
					<a href="forumManage_editPage?id=${id}">修改</a>
					<s:if test="#stat.first">
						<span style="color: gray;cursor:pointer">上移</span>
					</s:if>
					<s:else>
						<a href="forumManage_up?id=${id }">上移</a>
					</s:else>
					
					<s:if test="#stat.last">
						<span style="color: gray;cursor:pointer">下移</span>
					</s:if>
					<s:else>
					<a href="forumManage_down?id=${id }">下移</a>
					
					</s:else>
				</td>
			</tr>
        </s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="forumManage_addPage"><img src="style/images/createNew.png" /></a>
        </div>
    </div>
</div>

<div class="Description">
	说明：<br />
	1，显示的列表按其sortOrder值升序排列。<br />
	2，可以通过上移与下移功能调整顺序。最上面的不能上移，最下面的不能下移。<br />
</div>

</body>
</html>