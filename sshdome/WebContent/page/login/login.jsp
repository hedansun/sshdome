<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ include file="/page/base/base.jsp"%>

<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
  </head>
  
  <body>
  <center>
    <form action="${pageContext.request.contextPath }/user/login" method="post">
    	<table cellpadding="5" cellspacing="10">
    		<tr>
    			<td id="message" colspan="2" style="height: 20px;color: red"></td>
    		</tr>
    		<tr>
    			<td>用户:</td>
    			<td><input id="name" name="name" type="text"/></td>
    		</tr>
    		<tr>
    			<td>密码:</td>
    			<td><input id="password" name="password" type="password"/></td>
    		</tr>
    	</table>
    	<input id="loginBut" type="submit" value="登录">
    	<br>
    	<br>
    	<br>
    </form>
    </center>
  </body>
</html>
