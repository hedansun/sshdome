<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ include file="/page/base/base.jsp"%>

<html>
  <head>
    <title>top</title>
	<script type="text/javascript">
		$(function(){
			var userEmail="<s:property value="#session.userEmail"/>";
			if(userEmail!=null&&userEmail!=""){
				$("#userDiv").hide();
				$("#loginP").show();
			}else{
				$("#userDiv").show();
				$("#loginP").hide();
			}
			$("#destroy").click(function(){
				$.ajax({
					type:"post",
					url:"${pageContext.request.contextPath}/user/destroy",
					success:function(){
						$("#userDiv").show();
						$("#loginP").hide();
						$.inform("注销成功!");
						location.reload();
					}
				});
			});
			
			$("#login").click(function(){
				showLogin();
	    	});
	    				
			$("#register").click(function(){
				var sessionValidateCode="";
				$.dialog({
					title:"注册",
					content:$("#registerDiv"),
					btns: ["accept","cancel"],
	    			onLoad:function(){
	    				//点击图片更换验证码
	    			    $("#Verify").click(function(){
	    			        $(this).attr("src","${pageContext.request.contextPath }/user/validateImageCode?timestamp="+new Date().getTime());
	    			    });
	    			},
	    			onBeforeAccept:function(){
	    				var emailReg = /^\w{3,}@\w+(\.\w+)+$/;
	    				var email=$("#email").val();
	    				var pw=$("#password").val();
	    				var pw2=$("#password2").val();
	    				var validateCode=$("#validateCode").val();
	    				if(email==""){
	    					$("#registerMessage").text();
	    					$("#registerMessage").text("邮箱为空!");
	    					$("#email").focus();
	    					return false;
	    				}else if(email!="" && !emailReg.test(email)){
	    					$("#registerMessage").text();
	    					$("#registerMessage").text("邮箱格式错误!");
	    					$("#email").focus();
	    					return false;
	    				}else if(pw==""&&email!=""){
	    					$("#registerMessage").text();
	    					$("#registerMessage").text("密码为空!");
	    					$("#password").focus();
	    					return false;
	    				}else if(pw2==""&&email!=""&&pw!=""){
	    					$("#registerMessage").text();
	    					$("#registerMessage").text("确认密码为空!");
	    					$("#password2").focus();
	    					return false;
	    				}else if(pw!=pw2){
	    					$("#registerMessage").text();
	    					$("#registerMessage").text("密码不一致!");
	    					$("#password2").focus();
	    					return false;
	    				}else if(validateCode==""){
	    					$("#registerMessage").text();
	    					$("#registerMessage").text("验证码为空!");
	    					$("#validateCode").focus();
	    					return false;
	    				}
	    				$("#registerMessage").text();
	    				var result="";
	    				$.ajax({
	    					type:"post",
	    					url:"${pageContext.request.contextPath }/user/register",
	    					data:{"user.email":email,"user.password":pw,"validateCode":validateCode},
	    					async: false,
	    					success:function(data){
	    						result=data;
	    					}
	    				});
	    				if(result=="1"){
	    					$("#registerMessage").text();
	    					$("#registerMessage").text("验证码错误!");
	    					$("#validateCode").focus();
	    					return false;
	    				}else if(result=="2"){
	    					$("#registerMessage").text();
	    					$("#registerMessage").text("邮箱存在!");
	    					$("#email").focus();
	    					return false;
	    				}else if(result=="0"){
	    					$.inform("注册成功!");
	    					location.reload();
	    				}
	    			},
	    			onClose: function(event) {
	    				
	    			}
				});
			});
			
			//初始化选中Home菜单
			var pageName="<s:property value="#session.pageName"/>";
			$("#"+pageName).css("background-color","#ddd");
			
			//鼠标移到菜单颜色变化		
			
		});
		
		function submenuList(id){
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath }/menu/submenuList",
				data:{"menu.id":id},
				success:function(data){
					var div = "<div id='menu_div_li_"+id+"' class = 'menu_div' onmouseout='cateHidden(this.id,event);'>";
					$.each(data, function(i, item) {
						div += item.menuName;
					});
					div +="</div>";
					$("#menu_ul").after(div);
				}
			});
		}
		
		function showmenu(){
			$("#menu_ul").show();
		}
		function showLogin(){
			$.dialog({title:"登录",
    			content:$("#loginDiv"),
    			btns: ["accept","cancel"],
    			onLoad:function(){
    				$("#email").focus();
    			},
    			onBeforeAccept: function(event) {
    				var email=$("#email").val();
    				var pw=$("#password").val();
    				var result2;
    				var emailReg = /^\w{3,}@\w+(\.\w+)+$/;
    				if(email==""){
    					$("#loginMessage").text();
    					$("#loginMessage").text("邮箱为空!");
    					$("#email").focus();
    					return false;
    				}else if(email!="" && !emailReg.test(email)){
    					$("#loginMessage").text();
    					$("#loginMessage").text("邮箱格式错误!");
    					$("#email").focus();
    					return false;
    				}else if(pw==""&&email!=""){
    					$("#loginMessage").text();
    					$("#loginMessage").text("密码为空!");
    					$("#password").focus();
    					return false;
    				}
    				$("#loginMessage").text();
    				$.ajax({
    					type:"post",
    					url:"${pageContext.request.contextPath }/user/login",
    					data:{"user.email":email,"user.password":pw},
    					async: false,
    					success:function(result){
    						result2=result;
    					}
    				});
    				if(result2==0){
						location.reload();
					}else if(result2==1){
						$("#loginMessage").text("邮箱不存在!");
						return false;
					}else{
						$("#loginMessage").text("密码错误!");
						return false;
					}
    			},
    			onClose: function(event) {
    				
    			}
    		});
		}
	</script>
  </head>
  
  <body>
  	<!-- 锚链接 -->
  	<a name="topdiv"></a>
  	<div id="navigate_div2" class="top_div3">
  		<div style="margin: 0 auto;width: 1000px;">
  		  	<div style="padding: 5px 0;height: 18px;">
  		  		<font style="color: #fff;">Welcome to javarise !</font>
  		  		<div style="float: right;">
  		  			<div id="userDiv" style="display: none;"><img alt="" src="${pageContext.request.contextPath }/image/contact.png" style="height: 16px;vertical-align:text-top;"> <a href="javascript:void(0)" id="login">登录</a> / <a href="javascript:void(0)" id="register">注册</a></div>
					<div id="loginP" style="display: none;"><img alt="" src="${pageContext.request.contextPath }/image/contact.png" style="height: 16px;vertical-align:text-top;"> <s:property value="#session.userEmail"/> / <a id="destroy" href="#">注销</a> / <a href="${pageContext.request.contextPath }/management">管理</a></div>
  		  		</div>
  		  	</div>
  		</div>
  	</div>
	<div id="navigate_div" class="top_navigate_div">
		<div style="margin: 10px auto;width: 1000px;"><a href="home"><font id="icon" class="top_font">JavaRise</font></a></div>
		<%----%>
		<div style="width: 100%;background-color: #ccc;">
			<div class="top_div2">
				<table style="" cellpadding="0" cellspacing="0">
					<tr>
						<td id="home" style="width: 150px;height: 60px;" onmouseover="showmenu();"><a href="home" onmouseover="showmenu();" style="color: #fff;font-size: 22px;margin-left: 5px;">首页</a></td>
						<td id="about" style="width: 150px;height: 60px;"><a href="${pageContext.request.contextPath }/page/about.jsp" style="color: #fff;font-size: 22px;margin-left: 5px;">关于</a></td>
					</tr>
				</table>
			</div>
			
			<div class="top_div2">
				<ul id="menu_ul" onmouseout="cateHiddenMenuUl(this.id,event);" style="display: none;">
					<s:iterator value="menuList">
						<li id="li_<s:property value="id" />" onmouseover="cateShow(this.id)"><s:property value="menuName" /></li>
						<script type="text/javascript">submenuList("<s:property value="id"/>")</script>
					</s:iterator>
				</ul>
			</div>
		</div>
	</div>
	<div id="loginDiv"style="display: none;">
		<div id="loginMessage" style="height: 12px;color:red;text-align: center;margin-top: 10px;"></div>
		<hr class="hr2">
		<table cellspacing="20" style="margin: 0 auto;">
    		<tr>
    			<td>邮箱:</td>
    			<td><input id="email" name="user.email" type="text" class="text"/></td>
    		</tr>
    		<tr>
    			<td>密码:</td>
    			<td><input id="password" name="user.password" type="password" class="text"/></td>
    		</tr>
    	</table>
    	<hr class="hr2">
	</div>
	<div id="registerDiv"style="display: none;">
		<div id="registerMessage" style="height: 12px;color:red;text-align: center;margin-top: 10px;"></div>
		<hr class="hr2">
		<table cellspacing="20" style="margin: 0 auto;">
    		<tr>
    			<td>邮箱:</td>
    			<td><input id="email" name="user.user.email" type="text" class="text"/></td>
    			<td></td>
    		</tr>
    		<tr>
    			<td>密码:</td>
    			<td><input id="password" name="user.password" type="password" class="text"/></td>
    			<td></td>
    		</tr>
    		<tr>
    			<td>确认密码:</td>
    			<td><input id="password2" name="user.password2" type="password" class="text"/></td>
    			<td></td>
    		</tr>
    		<tr>
    			<td>验证码:</td>
    			<td><input id="validateCode" name="validateCode" type="text" class="text"/></td>
    			<td><img title="看不清，换一张" src="${pageContext.request.contextPath }/user/validateImageCode" id="Verify"  style="cursor:hand;" alt="看不清，换一张"/></td>
    		</tr>
    	</table>
    	<hr class="hr2">
	</div>
  </body>
</html>
