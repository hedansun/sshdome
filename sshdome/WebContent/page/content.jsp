<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ include file="/page/base/base.jsp"%>

<html>
<head>
<title>JavaRise | <s:property value="content.contentTitle" escape="false"/></title>
<script type="text/javascript">
	$(function(){
		var name="<s:property value="#session.userEmail"/>";
		if(name!=null&&name!=""){
			$("#comment_div").hide();
			$("#comment_texa").attr("readonly",false);
			$("#comment_sub").attr("disabled",false)
		}
		
		$("#comment_div").click(function(){
			//showPage(400,300,'asdasda');
		});
	});
	window.onscroll = function(){ 
	    var t = document.documentElement.scrollTop || document.body.scrollTop;  
	    var top_div = document.getElementById( "top_bottom_div" ); 
	    if( t >= 200 ) { 
	        top_div.style.display = "inline"; 
	    } else { 
	        top_div.style.display = "none"; 
	    } 
	} 
</script>
</head>
<body>
	<div><%@ include file="/page/base/top.jsp" %></div>
	<div id="container">
		<div id="header"></div>
		<div id="mainContent">
			<p style="margin-bottom: 10px;"><a href="${pageContext.request.contextPath }/home">首页</a> >> <font style="color:gray;"><s:property value="content.contentTitle" escape="false"/></font></p>
			<div id="sidebar"></div>
			<div id="sidebar2">
				<div class="sidebar2_div">
					<ul>
						<li class="home_sidebar2_li">最新新闻</li>
						<s:iterator value="newContentList">
							<li class="home_sidebar2_li2">
								<s:if test="contentTitle.length()>22">
									<a title="<s:property value="contentTitle"/>" href="${pageContext.request.contextPath }/content/contentById?content.id=<s:property value="id" escape="false"/>"><s:property value="contentTitle.substring(0,22)" escape="false"/></a>
								</s:if>
								<s:else>
									<a title="<s:property value="contentTitle"/>" href="${pageContext.request.contextPath }/content/contentById?content.id=<s:property value="id" escape="false"/>"><s:property value="contentTitle" escape="false"/></a>
								</s:else>
							</li>
						</s:iterator>
					</ul>
				</div>
				<div class="sidebar2_div">
					<ul>
						<li class="home_sidebar2_li">最热评论</li>
						<li class="home_sidebar2_li2">
							<ul class="comment_div">
								<s:iterator value="content.comments">
									<li><s:property value="userId"/> <s:date name="dateTime" format="yyyy-MM-dd HH:mm:ss"/></li>
									<li><s:property value="commentContent"/></li>
									<hr class="hr2">
								</s:iterator>
							</ul>
						</li>
					</ul>
				</div>
			</div>
			<div class="content_content_2" id="content_2">
				<ul>
					<li style="font-size: 18px;font-weight: bold;text-align: center;line-height:200%;margin: 20px 0;"><s:property value="content.contentTitle" escape="false"/></li>
					<hr class="hr2">
					发布时间 :<s:date name="content.dateTime" format="yyyy-MM-dd HH:mm:ss"/>
					<!-- begin分享 -->
					<div class="content_bshare_div">
						<p class="BSHARE_TEXT" style="display: none;">
							<s:if test="content.contentBody.replaceAll('<[.[^<]]*>','').replaceAll(' ','').length()>150"><s:property value="content.contentBody.replaceAll('<[.[^<]]*>','').replaceAll('　', '').substring(0,150).trim()" escape="false"/> ...</s:if>
							<s:else><s:property value="content.contentBody.replaceAll('<[.[^<]]*>','').replaceAll('　','').replaceAll(' ','').trim()" escape="false"/></s:else>
						</p>
						<div class="bshare-custom"><a title="分享到QQ空间" class="bshare-qzone"></a><a title="分享到新浪微博" class="bshare-sinaminiblog"></a><a title="分享到人人网" class="bshare-renren"></a><a title="分享到腾讯微博" class="bshare-qqmb"></a><a title="分享到网易微博" class="bshare-neteasemb"></a><a title="更多平台" class="bshare-more bshare-more-icon more-style-sharethis"></a></div><script type="text/javascript" charset="utf-8" src="http://static.bshare.cn/b/buttonLite.js#style=-1&amp;uuid=7ba77fb1-4c51-4dd9-ba73-c85275d576af&amp;pophcol=1&amp;lang=zh"></script><script type="text/javascript" charset="utf-8" src="http://static.bshare.cn/b/bshareC0.js"></script>
					</div>
					<!-- end分享 -->
					<hr class="hr2">
					<li id ="contentBodyli"><s:property value="content.contentBody" escape="false" /></li>
				</ul>
			</div>
			<div style="width: 690px;margin-top: 10px;">
				<ul>
					<li class="home_sidebar2_li" >最近评论</li>
					<li class="home_sidebar2_li2">
						<ul class="comment_div">
							<s:iterator value="content.comments">
								<li><s:property value="userId"/> <s:date name="dateTime" format="yyyy-MM-dd HH:mm:ss"/></li>
								<li><s:property value="commentContent"/></li>
								<hr class="hr2">
							</s:iterator>
						</ul>
						<div>
							<div id ="comment_div" style="margin-top: 5px;position: absolute;"><a id="comment_div" href="javascript:void(0)" onclick="showLogin();">登录</a> 或 <a href="javascript:void(0);">注册</a> 后才能发表评论.</div>
							<form action="${pageContext.request.contextPath }/comment/addComment" method="post">
								<input type="hidden" name="content.id" value="<s:property value="content.id" />">
								<textarea id="comment_texa" name="comment.commentContent" rows="10" cols="108" readonly="readonly"></textarea>
								<br>
								<input id="comment_sub" type="submit" value="发表" disabled="true">
							</form>
						</div>
					</li>
				</ul>
			</div>
			<div class="top_bottom_div" id="top_bottom_div">
				<a href="#topdiv"><img title="返回顶部" alt="返回顶部" src="${pageContext.request.contextPath }/image/gotop.png" width="25px;"></a>
			</div>
		</div>
		<div id="footer"></div>
	</div>
	<%@ include file="/page/base/bottom.jsp" %>
  </body>
</html>