package com.hd.dao;

import java.util.List;

import com.hd.bean.Content;

public interface IContentDAO {

	public void contentAdd(Content content);
	
	public void contentDelete(int id);
	
	public void contentUpdate(Content content);
	
	public Content content(int id);
	
	public List contentList();
	
	public List hotContentList();
	
	public List getCommentNumberList();
	
	public List getNewContentList();
	
	public List contentList(int pageIndex,int pageCount);
	
	public int getPageCount();
}
