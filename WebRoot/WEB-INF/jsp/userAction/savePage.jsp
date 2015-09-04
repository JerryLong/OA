<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
	<title>用户信息</title>
    <%@include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 用户信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="user_%{id==null?'add':'edit'}">
    	<s:hidden name="id"></s:hidden>
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="style/blue/images/item_point.gif" /> 用户信息 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr><td width="100">所属部门</td>
                        <td><s:select list="depts" listKey="deptId" listValue="deptName" 
                         name="deptId" 
                         headerKey="" headerValue="====请选择部门====" cssClass="SelectStyle">
                            </s:select> 
                        </td>
                    </tr>
                    <tr><td>登录名</td>
                        <td><s:textfield name="loginName" cssClass="InputStyle"></s:textfield> *
							（登录名要唯一）
						</td><td><s:fielderror fieldName="model.loginName"></s:fielderror></td>
                    </tr>
                    <tr><td>姓名</td>
                        <td><s:textfield name="name" cssClass="InputStyle"></s:textfield> *</td><td><s:fielderror fieldName="model.name"></s:fielderror></td>
                    </tr>
					<tr><td>性别</td>
                        <td><s:radio name="sex"  list="#{'true':'男','false':'女'}" id="male"/> 
							 
						</td>
                    </tr>
					<tr><td>联系电话</td>
                        <td><s:textfield  name="phone" cssClass="InputStyle"/></td><td><s:fielderror fieldName="model.phone"></s:fielderror></td>
                    </tr>
                    <tr><td>E-mail</td>
                        <td><s:textfield name="emall" cssClass="InputStyle" /></td>
                    </tr>
                    <tr><td>备注</td>
                        <td><s:textarea name="description" cssClass="TextareaStyle"></s:textarea></td>
                    </tr>
                </table>
            </div>
        </div>
        
		<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="style/blue/images/item_point.gif" /> 岗位设置 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
						<td width="100">岗位</td>
                        <td><s:select list="#roles" listKey="id" listValue="name"
                      	  name="roleIds" multiple="true" size="10" cssClass="SelectStyle">
                            </s:select>
                            按住Ctrl键可以多选或取消选择
                        </td>
                    </tr>
                </table>
            </div>
        </div>		
		
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="style/images/goBack.png"/></a>
        </div>
    </s:form>
</div>

<div class="Description">
	说明：<br />
	1，用户的登录名要唯一，在填写时要同时检测是否可用。<br />
	2，新建用户后，密码被初始化为"1234"。<br />
	3，密码在数据库中存储的是MD5摘要（不是存储明文密码）。<br />
	4，用户登录系统后可以使用“个人设置→修改密码”功能修改密码。<br />
	5，新建用户后，会自动指定默认的头像。用户可以使用“个人设置→个人信息”功能修改自已的头像<br />
	6，修改用户信息时，登录名不可修改。
</div>
</body>
</html>

