package com.hd.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.hd.service.IContentService;
import com.hd.service.IMenuService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class HomeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List menuList;
	private List contentList;
	private List hotContentList;
	private List commentNumberList;
	private int pageIndex;
	private int pageCount;
	private int count;

	@Resource(name = "menuServiceImpl")
	private IMenuService menuService;
	@Resource(name = "contentServiceImpl")
	private IContentService iContentService;

	@Action(value = "/home", results = { @Result(name = "success", location = "/page/home.jsp") })
	public String home() {
		menuList = this.menuService.getMenuList();
		if(pageCount==0) pageCount=5;
		count = this.iContentService.getPageCount();
		contentList = this.iContentService.contentList(pageIndex,pageCount);
		hotContentList = this.iContentService.hotContentList();
		commentNumberList = this.iContentService.getCommentNumberList();
		return "success";
	}

	@Action(value = "/management", results = { @Result(name = "success", location = "/page/management.jsp") })
	public String management() {
		return "success";
	}

	public List getMenuList() {
		return menuList;
	}

	public void setMenuList(List menuList) {
		this.menuList = menuList;
	}

	public List getContentList() {
		return contentList;
	}

	public void setContentList(List contentList) {
		this.contentList = contentList;
	}

	public List getHotContentList() {
		return hotContentList;
	}

	public void setHotContentList(List hotContentList) {
		this.hotContentList = hotContentList;
	}

	public List getCommentNumberList() {
		return commentNumberList;
	}

	public void setCommentNumberList(List commentNumberList) {
		this.commentNumberList = commentNumberList;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
