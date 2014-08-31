package com.hd.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hd.base.impl.BaseDAOImpl;
import com.hd.bean.Content;
import com.hd.dao.IContentDAO;

@Repository
public class ContentDAOImpl extends BaseDAOImpl implements IContentDAO {

	public void contentAdd(Content content) {
		this.add(content);
	}
	
	public void contentDelete(int id){
		this.deleteById(Content.class, id);
	}
	
	public void contentUpdate(Content content){
		this.update(content);
	}
	
	public Content content(int id){
		return (Content) this.selectObject(Content.class, id);
	}
	
	public List contentList(){
		return this.selectByHql("from Content t order by t.id desc");
	}
	
	public List hotContentList(){
		return this.getListForPage("from Content t order by t.hits desc",0,10);
	}
	
	public List getCommentNumberList(){
		return this.getListForPage("from Content t order by t.commentNumber desc",0,10);
	}
	
	public List getNewContentList(){
		return this.getListForPage("from Content t order by t.id desc", 0, 10);
	}
	
	public List contentList(int offset,int length){
		return this.getListForPage("from Content t order by t.id desc", offset, length);
	}
	
	public int getPageCount(){
		return this.selectBySql("select count(1) from t_content");
	}

}
