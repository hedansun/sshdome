<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ include file="/page/base/base.jsp" %>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
	function contentDelete(id){
		$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath }/content/contentDelete",
			data:{"content.id":id},
			success:function(){
				$("#"+id).remove();
			}
		});
	}
	
	function contentUpdate(id){
		var menuId =$("#menuId"+id).val();
		var contentTitle =$("#contentTitle"+id).val();
		var contentBody =$("#contentBody"+id).val();
		var userId =$("#userId"+id).val();
		var dateTime =$("#dateTime"+id).val();
		$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath }/content/contentUpdate",
			data:{"content.id":id,"content.menuId":menuId,"content.contentTitle":contentTitle,"content.contentBody":contentBody,"content.userId":userId,"content.dateTime":dateTime},
			success:function(){
				
			}
		});
	}
	
</script>
</head>
<body>
	<table>
		<s:iterator value="contentList">
			<tr id="<s:property value="id"/>">
				<td><s:property value="id" /></td>
				<td><input id="menuId<s:property value="id"/>" type="text" value="<s:property value="menuId"/>"></td>
				<td><input id="contentTitle<s:property value="id"/>" style="width: 300px;" type="text" value="<s:property value="contentTitle"/>"></td>
				<td><textarea id="contentBody<s:property value="id"/>" rows="5" cols="80"><s:property value="contentBody"/></textarea></td>
				<td><input id="userId<s:property value="id"/>" type="text" value="<s:property value="userId"/>"></td>
				<td><input id="dateTime<s:property value="id"/>" type="text" value="<s:property value="dateTime"/>"></td>
				<td><a href="javascript:void(0);" onclick="contentUpdate(<s:property value="id"/>)">修改</a></td>
				<td><a href="javascript:void(0);" onclick="contentDelete(<s:property value="id"/>)">删除</a></td>
			</tr>
		</s:iterator>
	</table>
	<form action="${pageContext.request.contextPath }/content/contentAdd" method="post">
		<table>
			<tr>
				<td>菜单id</td>
				<td><input type="text" name="content.menuId"></td>
			</tr>
			<tr>
				<td>标题</td>
				<td><input type="text" name="content.contentTitle"></td>
			</tr>
			<tr>
				<td>内容</td>
				<td>
					<textarea rows="10" cols="40" name="content.contentBody"></textarea>
				</td>
			</tr>
			<tr>
				<td>用户</td>
				<td><input type="text" name="content.userId"></td>
			</tr>
		</table>
		<input type="submit" value="添加">
	</form>
</body>
</html>