package com.hd.dao;

import java.util.List;

import com.hd.bean.Comment;

public interface ICommentDAO {

	public void commentAdd(Comment comment);
	
	public void commentDelete(int id);
	
	public List commentList(int id);
}
