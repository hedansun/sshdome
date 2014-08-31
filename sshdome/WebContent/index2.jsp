<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/page/base/base.jsp"%>

<html>
  <head>
    <title>首页</title>
    <script type="text/javascript">
	    if(document.all){//如果是IE
	    	//引入html5media.min.js解决IE兼容性
	        document.write('<scr' + 'ipt type="text/javascript" src="http://html5media.googlecode.com/svn/trunk/src/html5media.min.js"></scr' + 'ipt>');  
	    }
	    function drag(ev){
			ev.dataTransfer.setData("Text",ev.target.id);
		}
		
		function allowDrop(ev){
			ev.preventDefault();
		}
		
		function drop(ev){
			ev.preventDefault();
			var data=ev.dataTransfer.getData("Text");
			ev.target.appendChild(document.getElementById(data));
		}
		
		var x=document.getElementById("demo");
		
		$(function(){
			$("#showckb").click(function(){
				alert(1);
			});
		});
    </script>
  </head>
  <body>
  	<%@ include file="/page/base/top.jsp"%>
  	<center>
  	<div id="div1" style="width: 400px;height: 240px;border: 1px solid #ccf;float: left;" ondragover="allowDrop(event)" ondrop="drop(event)">
  		<video id="drag1" width="320" height="240" controls ondragstart="drag(event)">
  			<source src="${pageContext.request.contextPath}/media/Chrome_ImF.mp4">
		</video>
  	</div>
	<audio controls loop>
		<source src="${pageContext.request.contextPath}/media/hdt.mp3">
		Your browser does not support the audio tag.
	</audio>
	<div id="div2" style="width: 400px;height: 240px;border: 1px solid #ccf;float:right;" ondragover="allowDrop(event)" ondrop="drop(event)">
  	</div>
  	<div style="width: 400px;height: 200px;background-color: #eef">
  		<form id="form1" name="form1" action="${pageContext.request.contextPath}/user/getUser" method="post">
			E-mail: <input type="input" name="email" /><br />
			<input type="submit" />
		</form>
  	</div>
  	<div style="width: 400px;height: 200px;background-color: #eef;margin-top:10px;">
		<form id="form2" name="form2" action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
			<input type="file" name="uploadFile">
			<input type="submit" value="上传">
		</form>
	</div>
	<div style="width: 400px;height: 200px;background-color: #eef;margin-top:10px; ">	
		<form id="form3" name="form3" action="${pageContext.request.contextPath}/download" method="post">
			<input name="fileName" type="hidden" value="hdt.mp3">
			<input name="filePath" type="hidden" value="/media/hdt.mp3">
			<input type="submit" value="下载">
		</form>
	</div>
	</center>
	1:<input id="ckb" type="checkbox" value="1">
	2:<input id="ckb" type="checkbox" value="2">
	3:<input id="ckb" type="checkbox" value="3">
	4:<input id="ckb" type="checkbox" value="4">
	5:<input id="ckb" type="checkbox" value="5">
	6:<input id="ckb" type="checkbox" value="6">
	7:<input id="ckb" type="checkbox" value="7">
	<input id="showckb" type="button" value="显示选择的值">
  </body>
</html>
