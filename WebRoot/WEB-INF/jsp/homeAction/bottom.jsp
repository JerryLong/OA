<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
    <title>Bottom</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="style/blue/statusbar.css" />
</head>
<body style="margin:0"> 

<div id="StatusBar">
    <div id="Online">
    	å¨çº¿äººåï¼å± <span class="OnlineUser" id="onlineUserNum"></span> äºº
        <span class="OnlineView"><a href="javascript:void(0)">[æ¥çå¨çº¿åå]</a></span>
    </div>
    <div id="Info">
    	<a href="http://localhost:8080/OA/index.jsp" title = "ç³»ç»é¦é¡µ" target="_blank">ç³»ç»é¦é¡µ</a> |
        <a href="http://localhost:8080/OA/index.jsp" title = "ç³»ç»BBS" target="_blank">ç³»ç»BBS</a> 
    </div>
    <div id="DesktopText">
        <a href="javascript:void(0)"><img border="0" src="style/images/top/text.gif"/>ä¾¿ç¬º</a>
        <span id=TryoutInfo></span>
        <span id="Version">
            <a href="javascript:void(0)">
            	<img border="0" width="11" height="11" src="style/images/top/help.gif" /> 
                <img border="0" width="40" height="11" src="style/blue/images/top/version.gif" />
            </a>
        </span>
    </div>
</div>

</body>
</html>
