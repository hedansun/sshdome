package com.hd.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.hd.bean.Menu;
import com.hd.service.IMenuService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@ParentPackage("default")
public class MenuAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private Menu menu;
	private List menuList;

	@Resource(name="menuServiceImpl") private IMenuService menuService;
	
	@Action(value = "/menu/menuAdd",results = {
			@Result(name = "success",type="redirect", location = "menuList")})
	public String menuAdd() throws Exception {
		if(menu!=null){
			this.menuService.menuAdd(menu);
		}
		return "success";
	}
	
	@Action(value = "/menu/menuDelete")
	public void menuDelete(){
		this.menuService.menuDelete(menu.getId());
	}
	
	@Action(value = "/menu/menuUpdate")
	public void menuUpdate(){
		this.menuService.menuUpdate(menu);
	}
	
	@Action(value = "/menu/menuList",results = {
			@Result(name = "success", location = "/page/menuList.jsp")})
	public String getListTMenu(){
		menuList = this.menuService.getMenuList();
		return "success";
	}
	
	@Action(value = "/menu/submenuList",results = {
			@Result(name="success",type="json",params={"root","menuList"})})
	public String submenuList(){
		menuList = this.menuService.submenuList(menu.getId());
		return "success";
	}
	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List getMenuList() {
		return menuList;
	}

	public void setMenuList(List menuList) {
		this.menuList = menuList;
	}
}
