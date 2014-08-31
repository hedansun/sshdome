package com.hd.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.hd.bean.Comment;
import com.hd.dao.ICommentDAO;
import com.hd.service.ICommentService;

@Service
public class CommentServiceImpl implements ICommentService {

	@Resource(name="commentDAOImpl")
	private ICommentDAO iCommentDAO;
	
	public void commentAdd(Comment comment) {
		this.iCommentDAO.commentAdd(comment);
	}
	
	public void commentDelete(int id){
		this.iCommentDAO.commentDelete(id);
	}
	
	public List commentList(int id){
		return this.iCommentDAO.commentList(id);
	}
}
