<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
    <title>bottom</title>
	<script type="text/javascript">
	
	$(function(){
		var h = $("#bom_div").width();
		if(h<1000){
			$("#bom_div").css("width","1000px");
		}
	});
	
	$(window).resize(function(){
		var w = document.body.offsetWidth;
		var h = $("#bom_div").width();
		if(h<1000){
			$("#bom_div").css("width","1000px");
		}
		if(w>1000){
			$("#bom_div").css("width","100%");
		}
	});
	</script>
  </head>
  
  <body>
    <div id="bom_div" class="bom">
   		<br>
    	Design by javarise&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;邮箱:hedansun@sina.com
    	</br>
    	Copyright &copy;2013&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="http://www.javarise.com">java崛起</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;All Rights Reserved.
    	</br>
    	<center>
    	<a href="http://www.w3.org/html/logo/">
			<img src="http://www.w3.org/html/logo/downloads/HTML5_Badge_32.png" width="32" height="32" alt="HTML5 Powered" title="HTML5 Powered">
		</a>
		</br>
    	<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cdiv id='cnzz_stat_icon_1000047289'%3E%3C/div%3E%3Cscript src='" + cnzz_protocol + "s22.cnzz.com/z_stat.php%3Fid%3D1000047289%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));</script>
		</center>
    </div>
  </body>
</html>
