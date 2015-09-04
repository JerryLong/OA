<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>导航菜单</title>
<%@include file="/WEB-INF/jsp/public/commons.jspf"%>
<script language="JavaScript" src="script/menu.js"></script>
<link type="text/css" rel="stylesheet" href="style/blue/menu.css" />
</head>
<body style="margin: 0;overflow:hidden;">
	<div id="Menu">
		<ul id="MenuUl">
			<s:iterator value="#application.topPrivilegeList">
				<s:if test="#session.user.hasPrivilegeByName(name)">
				<li class="level1" >
					<div onClick="menuClick(this);" class="level1Style">
						<img src="style/images/MenuIcon/FUNC20082.gif" class="Icon" />${name}
					</div>
					<ul style="display: none;" class="MenuLevel2">
					<s:iterator value="chlidren">
						<s:if test="#session.user.hasPrivilegeByName(name)">
						<li class="level2">
							<div class="level2Style">
								<img src="style/images/MenuIcon/menu_arrow_single.gif" /> <a
									target="right" href="${pageContext.request.contextPath}${url }.action"> ${name }</a>
							</div>
						</li>
						</s:if>
					</s:iterator>
					</ul>
				</li>
				</s:if>
			</s:iterator>
		</ul>
	</div>
</body>
</html>
