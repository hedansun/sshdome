<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/page/base/base.jsp"%>

<%
	session.setAttribute("pageName","home");
%>

<html>
  <head>
    <title>JavaRise</title>
    <script type="text/javascript">
	    if(document.all){//如果是IE
	    	//引入html5media.min.js解决IE兼容性
	        //document.write('<scr' + 'ipt type="text/javascript" src="http://html5media.googlecode.com/svn/trunk/src/html5media.min.js"></scr' + 'ipt>');  
	    }
	    $(function (){
	    	
	    });
	    $(window).resize(function (){

	    });
    </script>
  </head>
  <body>
  	<%@ include file="/page/base/top.jsp" %>
	<div id="container">
		<div id="header"></div>
		<div id="mainContent">
			<div id="sidebar"></div>
			<div id="sidebar2">
				<div class="sidebar2_div">
					<ul>
						<li class="home_sidebar2_li">最热新闻</li>
						<s:iterator value="hotContentList">
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
						<li class="home_sidebar2_li">最多评论</li>
						<s:iterator value="commentNumberList">
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
			</div>
			<div id="content">
				<s:iterator value="contentList">
				<ul class="home_content">
					<s:if test="contentBody.matches('.*(src=\").*')">
						<span style="float: right;height: 160px;overflow: hidden;margin-top: 30px;"><img src="<s:property value="contentBody.replaceAll('(\".alt).*','').replaceAll('.*(src=\")','')"/>" style="width: 200px;display: block;"></span>
					</s:if>
					<li class="home_content_li"><a href="${pageContext.request.contextPath }/content/contentById?content.id=<s:property value="id"/>"><s:property value="contentTitle" escape="false"/></a></li>
					<li>
						<s:if test="contentBody.replaceAll('<[.[^<]]*>','').replaceAll('　','').length()>150"><s:property value="contentBody.replaceAll('<[.[^<]]*>','').replaceAll('　','').substring(0,150).trim()" escape="false"/> ...</s:if>
						<s:else><s:property value="contentBody.replaceAll('<[.[^<]]*>','').replaceAll('　','').trim()" escape="false"/></s:else>
					</li>
					<li><a href="javascript:void(0);"><s:property value="userId" /></a>发布于<s:date name="dateTime" format="yyyy-MM-dd HH:mm:ss"/> 阅读 (<s:property value="hits"/>) 评论 (<s:property value="commentNumber"/>)</li>
				</ul>
				</s:iterator>
				<div class="home_content_div">
					<!-- 
					<s:iterator begin="1" end="(count+5-1)/5" step="1" status="s">
						<s:if test="#s.index==pageIndex/pageCount">
							<a class="home_content_a"><s:property value="#s.index+1"/></a>
						</s:if>
						<s:else>
							<a class="home_content_a2" href="${pageContext.request.contextPath }/home?pageIndex=<s:property value="#s.index*5"/>&pageCount=5"><s:property value="#s.index+1"/></a>
						</s:else>
					</s:iterator>
					 -->
					<s:if test="(pageIndex/pageCount)>7">
					 	<s:set name="beginNumber" value="pageIndex/pageCount-6"/>
					</s:if>
					<s:else>
						<s:set name="beginNumber" value="1"/>
					</s:else>
					<s:if test="pageIndex/pageCount+1>1">
						&nbsp;<a class="home_content_a2" title="最前页" href="${pageContext.request.contextPath }/home?pageIndex=<s:property value="0"/>&pageCount=5"> << </a>
					</s:if>
					<s:if test="pageIndex/pageCount>0">
						&nbsp<a class="home_content_a2" title="上一页" href="${pageContext.request.contextPath }/home?pageIndex=<s:property value="pageIndex-5"/>&pageCount=5"> < </a>&nbsp;
					</s:if>
					<s:iterator begin="beginNumber" end="pageIndex/pageCount+8" status="s">
						<s:if test="#beginNumber+#s.index==pageIndex/pageCount+1 && #beginNumber+#s.index<=(count+5-1)/5">
							<a class="home_content_a"><s:property value="#beginNumber+#s.index"/></a>
						</s:if>
						<s:elseif test="#beginNumber+#s.index<=(count+5-1)/5">
							<a class="home_content_a2" href="${pageContext.request.contextPath }/home?pageIndex=<s:property value="(#beginNumber+#s.index-1)*5"/>&pageCount=5"><s:property value="#beginNumber+#s.index"/></a>
						</s:elseif>
					</s:iterator>
					<s:if test="pageIndex/pageCount+1<(count+5-1)/5">
						<a class="home_content_a2" title="下一页" href="${pageContext.request.contextPath }/home?pageIndex=<s:property value="pageIndex+5"/>&pageCount=5"> > </a>
					</s:if>
					<s:if test="pageIndex/pageCount+1<(count+5-1)/5">
						&nbsp;<a class="home_content_a2" title="最后页" href="${pageContext.request.contextPath }/home?pageIndex=<s:property value="((count+5-1)/5-1)*5"/>&pageCount=5"> >> </a>
					</s:if>
				</div>
			</div>
		</div>
		<div id="footer"></div>
	</div>
	<%@ include file="/page/base/bottom.jsp" %>
  </body>
</html>
