<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ include file="/page/base/base.jsp"%>
<html>
<head>
<title>menu add</title>
<script type="text/javascript">
	function menuDelete(id){
		$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath }/menu/menuDelete",
			data:{"menu.id":id},
			success:function(){
				$("#"+id).remove();
			}
		});
	}
	
	function menuUpdate(id){
		var pid =$("#pid"+id).val();
		var menuName =$("#menuName"+id).val();
		var orderof =$("#orderof"+id).val();
		var show =$("#show"+id).val();
		$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath }/menu/menuUpdate",
			data:{"menu.id":id,"menu.pid":pid,"menu.menuName":menuName,"menu.orderof":orderof,"menu.show":show},
			success:function(){
				
			}
		});
	}
	
	function submenuList(id){
		$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath }/menu/submenuList",
			data:{"menu.id":id},
			success:function(data){
				$.each(data, function(i, item) {
					var tr = "<tr id='"+item.id+"'><td width='140px' style='display:none'><input id='pid"+item.id+"' value='"+item.pid+"'></td>";
					tr += "<td><input id='menuName"+item.id+"' value='"+item.menuName+"'></td>";
					tr += "<td><input id='orderof"+item.id+"' value='"+item.orderof+"'></td>";
					tr += "<td><input id='show"+item.id+"' value='"+item.show+"'></td>";
					tr += "<td><a href='javascript:void(0)' onclick='menuUpdate("+item.id+");'>保存子菜单</a></td>";
					tr += "<td><a href='javascript:void(0)' onclick='menuDelete("+item.id+");'>删除子菜单</a></td></tr>";
					$("#submenu"+id).after(tr);
				});
			}
		});
	}
</script>
</head>
<body>
	<div>
		<table>
			<tr>
				<td>菜单名字</td>
				<td>显示顺序</td>
				<td>是否显示</td>
				<td></td>
				<td></td>
			</tr>
			<s:iterator value="menuList">
			<tr id="<s:property value="id"/>">
				<td style="display: none"><input id="pid<s:property value="id"/>" type="text" value="<s:property value="pid"/>"></td>
				<td><input id="menuName<s:property value="id"/>" type="text" value="<s:property value="menuName"/>"></td>
				<td><input id="orderof<s:property value="id"/>" type="text" value="<s:property value="orderof"/>"></td>
				<td><input id="show<s:property value="id"/>" type="text" value="<s:property value="show"/>"></td>
				<td><a href="javascript:void(0)" onclick="menuUpdate(<s:property value="id"/>)">保存菜单</a></td>
				<td><a href="javascript:void(0)" onclick="menuDelete(<s:property value="id"/>)">删除菜单</a></td>
			</tr>
			<tr id="submenu<s:property value="id"/>">
				<script type="text/javascript">submenuList("<s:property value="id"/>")</script>
			</tr>
			<form action="${pageContext.request.contextPath }/menu/menuAdd" method="post">
			<tr>
				<td  style="display: none"><input type="text" name="menu.pid" value="<s:property value="id"/>"></td>
				<td><input type="text" name="menu.menuName"></td>
				<td><input type="text" name="menu.orderof"></td>
				<td><input type="text" name="menu.show"></td>
				<td><input type="submit" value="添加子菜单"></td>
			</tr>
			</form>
			</s:iterator>
		</table>
	</div>
	<br>
	<br>
	<form id="menuAddForm" action="${pageContext.request.contextPath }/menu/menuAdd" method="post">
		<table>
			<tr>
				<td width="140px;"><input type="text" id="menuName" name="menu.menuName"></td>
				<td><input type="text" id="orderof" name="menu.orderof"></td>
				<td><input type="text" id="show" name="menu.show"></td>
				<td><input type="submit" value="添加菜单"></td>
			</tr>
		</table>
	</form>
</body>
</html>