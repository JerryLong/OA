<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
<head>
	<title>【${forum.name }】中的主题列表</title>
    <%@include file="/WEB-INF/jsp/public/commons.jspf" %>
	<link type="text/css" rel="stylesheet" href="style/blue/forum.css" />
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 【${forum.name }】中的主题列表
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
	<div id="PageHead"></div>
	<center>
		<div class="ItemBlock_Title1" style="width: 98%;">
			<font class="MenuPoint"> &gt; </font>
			<s:a action="forum_list">论坛</s:a>
			<font class="MenuPoint"> &gt; </font>
			${forum.name }
			<span style="margin-left:30px;"><a href="topic_addPage?forumId=${forum.id }">
				<img align="absmiddle" src="style/blue/images/button/publishNewTopic.png"/></a>
			</span>
		</div>
		
		<div class="ForumPageTableBorder">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<!--表头-->
				<tr align="center" valign="middle">
					<td width="3" class="ForumPageTableTitleLeft">
						<img border="0" width="1" height="1" src="style/images/blank.gif" />
					</td>
					<td width="50" class="ForumPageTableTitle"><!--状态/图标-->&nbsp;</td>
					<td class="ForumPageTableTitle">主题</td>
					<td width="130" class="ForumPageTableTitle">作者</td>
					<td width="100" class="ForumPageTableTitle">回复数</td>
					<td width="130" class="ForumPageTableTitle">最后回复</td>
					<td width="3" class="ForumPageTableTitleRight">
						<img border="0" width="1" height="1" src="style/images/blank.gif" />
					</td>
				</tr>
				<tr height="1" class="ForumPageTableTitleLine"><td colspan="8"></td></tr>
				<tr height=3><td colspan=8></td></tr>
					
				<!--主题列表-->
				<tbody class="dataContainer" >
					<s:iterator value="recordList">
					<tr height="35" id="d0" class="template">
						<td></td>
						<td class="ForumTopicPageDataLine" align="center"><img src="style/images/topicType_${type}.gif" /></td>
						<td class="Topic"><a class="Default" href="topic_show.action?id=${id }">${title}</a></td>
						<td class="ForumTopicPageDataLine">
							<ul class="ForumPageTopicUl">
								<li class="Author">${author.name }</li>
								<li class="CreateTime">${postTime }</li>
							</ul>
						</td>
						<td class="ForumTopicPageDataLine Reply" align="center"><b>${replyCount}</b></td>
						<td class="ForumTopicPageDataLine">
							<ul class="ForumPageTopicUl">
								<li class="Author">${lastReply.author.name }</li>
								<li class="CreateTime">${lastReply.postTime }</li>
							</ul>
						</td>
						<td></td>
					</tr>
					</s:iterator>
					
					</tbody>
					<!--主题列表结束-->	
						
					<tr height="3"><td colspan="9"></td></tr>
				
			</table>
			
			<!--其他操作-->
			<s:form id="fo" action="forum_show?id=%{id}" method="post">
			<div id="TableTail">
				<div id="TableTail_inside">
					<table border="0" cellspacing="0" cellpadding="0" height="100%" align="left">
						<tr valign=bottom>
							<td></td>
							<td>
								<s:select name="viewType" list="#{'0':'全部主题',1:'全部精华贴'}" />
								<s:select name="orderBy" list="#{'0':'默认排序（按最后更新时间排序，但所有置顶帖都在前面）',1:'按最后更新时间排序',2:'按主题发表时间排序',3:'按回复数量排序'}" />
								<s:select name="reverse" list="#{'true':'降序','false':'升序' }" />
								<input type="IMAGE" src="style/blue/images/button/submit.PNG" align="ABSMIDDLE"/>
							</td>
						</tr>
					</table>
				</div>
			</div>
			</s:form>
			
		</div>
	</center>
</div>

<!--分页信息-->
<div id=PageSelectorBar>
			<div id=PageSelectorMemo>
				页次：${currentPage}/${pageCount}页 &nbsp;
				每页显示：${pageSize}条 &nbsp;
				总记录数：${recordCount}条
			</div>
			<div id=PageSelectorSelectorArea>
				<!--
				<IMG SRC="style/blue/images/pageSelector/firstPage2.png"/>
				-->
				<a href="javascript:gotoPageNum(1)" title="首页" style="cursor: hand;">
					<img src="style/blue/images/pageSelector/firstPage.png"/></a>
				<s:iterator begin="beginPageIndex" end="endPageIndex" var="num">
				<s:if test="#num == currentPage">
					<span class="PageSelectorNum PageSelectorSelected">${num}</span>
				</s:if>
				<s:else>
					<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPageNum(${num});">${num }</span>
				</s:else>
				</s:iterator>
				<!--
				<IMG SRC="style/blue/images/pageSelector/lastPage2.png"/>
				-->
				<a href="javascript:gotoPageNum(${pageCount})" title="尾页" style="cursor: hand;">
					<img src="style/blue/images/pageSelector/lastPage.png"/></a>
		
		转到：
		<input onFocus="this.select();" maxlength="2" class="inputStyle" type="text" value="1" name="currPage" tabindex="0"/>
		<input type="submit" name="goBtn" value="Go" class="MiddleButtonStyle" />
		<script type="text/javascript">
			function gotoPageNum(num) {
				//window.location.href="forum_show.action?id=${id}&pageNum="+num;
				var forn = $('#fo');
				forn.append("<input type='hidden' name='pageNum' value='"+num+"'></input>");
				forn.submit();
			}
		</script>
	</div>
</div>

<div class="Description">
	说明：<br />
	1，主题默认按最后更新的时间降序排列。最后更新时间是指主题最后回复的时间，如果没有回复，就是主题发表的时间。<br />
	2，帖子有普通、置顶、精华之分。置顶贴始终显示在最上面，精华贴用不同的图标标示。<br />
</div>

</body>
</html>
