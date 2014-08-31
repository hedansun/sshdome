package com.hd.action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hd.bean.Comment;
import com.hd.bean.Content;
import com.hd.service.ICommentService;
import com.hd.service.IContentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@ParentPackage("default")
public class ContentAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private Content content;
	private Comment comment;
	private List contentList;
	private List commentList;
	private List newContentList;
	
	@Resource(name="contentServiceImpl")
	private IContentService iContentService;
	
	@Resource(name="commentServiceImpl")
	private ICommentService iCommentService;
	
	@Action(value="/content/contentAdd",results={@Result(name="success",type="redirect",location="contentList")})
	public String contentAdd(){
		if(content!=null){
			this.iContentService.contentAdd(content);
		}
		return "success";
	}
	
	@Action(value="/content/contentDelete")
	public void contentDelete(){
		this.iContentService.contentDelete(content.getId());
	}
	
	@Action(value="/content/contentUpdate")
	public void contentUpdate(){
		this.iContentService.contentUpdate(content);
	}
	
	@Action(value="/content/contentList",results={@Result(name="success",location="/page/contentList.jsp")})
	public String contentList(){
		if(content!=null){
			this.iContentService.contentAdd(content);
		}
		contentList = this.iContentService.contentList();
		return "success";
	}
	
	@Action(value="/content/contentById",results={@Result(name="success",location="/page/content.jsp")})
	public String contentById(){
		content = this.iContentService.content(content.getId());
		newContentList=this.iContentService.getNewContentList();
		content.setHits(content.getHits()+1);
		this.iContentService.contentUpdate(content);
		return "success";
	}
	
	public Content getContent() {
		return content;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public List getContentList() {
		return contentList;
	}
	public void setContentList(List contentList) {
		this.contentList = contentList;
	}
	public List getCommentList() {
		return commentList;
	}
	public void setCommentList(List commentList) {
		this.commentList = commentList;
	}
	public List getNewContentList() {
		return newContentList;
	}
	public void setNewContentList(List newContentList) {
		this.newContentList = newContentList;
	}
}
