<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	session.setAttribute("pageName","about");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>JavaRise | about</title>
  </head>
  
  <body>
  	<%@ include file="/page/base/top.jsp" %>
  	<div id="container">
		<div id="header"></div>
		<div id="mainContent">
			<div id="sidebar"></div>
			<div id="sidebar2">
			</div>
			<div id="content" style="height: 400px;">
				<br><br><br>
				<font style="font-size: 18px;">不积蛙步，无以至千里；<br>
				不积小流，无以成江海。</font><br><br>
				自己出于爱好做了这个dome，无奈缺少动力，写写停停，最近工作没有那么忙了，抽点时间完善一下。<br>
				无奈对于前端设计不太熟练，界面比较生硬，色彩比较单调，现在总算迈出了第一步吧，后续会把一些基本功能给补齐。<br><br>
				大家一起
				<font>厚</font>
				<font style="font-size: 16px;">积</font>
				<font style="font-size: 20px;">薄</font>
				<font style="font-size: 24px;">发</font>
				吧！
			</div>
		</div>
		<div id="footer"></div>
	</div>
    <%@ include file="/page/base/bottom.jsp" %>
  </body>
</html>
