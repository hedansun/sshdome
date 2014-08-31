package com.hd.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.hd.bean.Comment;
import com.hd.bean.Content;
import com.hd.service.ICommentService;
import com.hd.service.IContentService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@ParentPackage("default")
public class CommentAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	private Content content;
	private Comment comment;
	private List commentList;
	
	@Resource(name="commentServiceImpl")
	private ICommentService iCommentService;
	@Resource(name="contentServiceImpl")
	private IContentService iContentService;
	
	@Action(value="/comment/addComment",results={@Result(name="success",type="redirect",params={"content.id","${content.getId()}"},location="/content/contentById")})
	public String addComment(){
		comment.setContentId(content.getId());
		if(comment!=null){
			this.iCommentService.commentAdd(comment);
		}
		content = this.iContentService.content(content.getId());
		content.setCommentNumber(content.getCommentNumber()+1);
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
	public List getCommentList() {
		return commentList;
	}
	public void setCommentList(List commentList) {
		this.commentList = commentList;
	}
}
