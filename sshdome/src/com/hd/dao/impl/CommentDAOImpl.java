package com.hd.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hd.base.impl.BaseDAOImpl;
import com.hd.bean.Comment;
import com.hd.dao.ICommentDAO;

@Repository
public class CommentDAOImpl extends BaseDAOImpl implements ICommentDAO {

	public void commentAdd(Comment comment) {
		this.add(comment);
	}

	public void commentDelete(int id) {
		this.deleteById(Comment.class, id);
	}
	
	public List commentList(int id){
		return this.selectByHql("from Comment t where t.contentId="+id);
	}

}
