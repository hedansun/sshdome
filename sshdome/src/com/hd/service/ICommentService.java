package com.hd.service;

import java.util.List;

import com.hd.bean.Comment;

public interface ICommentService {

	public void commentAdd(Comment comment);
	
	public void commentDelete(int id);
	
	public List commentList(int id);
}
