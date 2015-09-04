<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>论坛</title>
    <%@include file="/WEB-INF/jsp/public/commons.jspf" %>
	<link type="text/css" rel="stylesheet" href="style/blue/forum.css" />
	<script type="text/javascript">
	</script>
</head>
<body>
<div id="Title_bar">
	<div id="Title_bar_Head">
		<div id="Title_Head"></div>
		<div id="Title">
			<!--页面标题-->
			<img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 论坛 </div>
		<div id="Title_End"></div>
	</div>
</div>
<div id="MainArea">
	<center>
		<div class="ForumPageTableBorder" style="margin-top: 25px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			
				<!--表头-->
				<tr align="center" valign="middle">
					<td colspan="3" class="ForumPageTableTitleLeft">版块</td>
					<td width="80" class="ForumPageTableTitle">主题数</td>
					<td width="80" class="ForumPageTableTitle">文章数</td>
					<td width="270" class="ForumPageTableTitle">最后发表的主题</td>
				</tr>
				<tr height="1" class="ForumPageTableTitleLine"><td colspan="9"></td></tr>
				<tr height="3"><td colspan="9"></td></tr>
			
				<!--版面列表-->
				<tbody class="dataContainer" >
				<s:iterator value="#forumList">
				<tr height="78" align="center" class="template">
					<td width="3"></td>
					<td width="75" class="ForumPageTableDataLine">
						<img src="style/images/forumpage3.gif" />
					</td>
					<td class="ForumPageTableDataLine">
						<ul class="ForumPageTopicUl">
							<li class="ForumPageTopic"><a class="ForumPageTopic" href="forum_show.action?id=${id }">${name}</a></li>
							<li class="ForumPageTopicMemo">${description}</li>
						</ul>
					</td>
					<td class="ForumPageTableDataLine"><b>${topicCount}</b></td>
					<td class="ForumPageTableDataLine"><b>${articleCount}</b></td>
					<td class="ForumPageTableDataLine">
						<ul class="ForumPageTopicUl">
							<li><font color="#444444">┌ 主题：</font> 
								<s:a class="ForumTitle" action="topic_show?id=%{lastTopic.id }">${lastTopic.title}</s:a>
							</li>
							<li><font color="#444444">├ 作者：</font> ${lastTopic.author.name}</li>
							<li><font color="#444444">└ 时间：</font> ${lastTopic.postTime}</li>
						</ul>
					</td>
					<td width="3"></td>
				</tr>
				</s:iterator>
				
				
				</tbody>
				<!-- 版面列表结束 -->
				
				<tr height="3"><td colspan="9"></td></tr>
			</table>
		</div>
	</center>
</div>
</body>
</html>
    