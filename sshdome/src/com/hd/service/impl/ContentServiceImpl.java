package com.hd.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.hd.bean.Content;
import com.hd.dao.IContentDAO;
import com.hd.service.IContentService;

@Service
public class ContentServiceImpl implements IContentService {

	@Resource(name="contentDAOImpl")
	private IContentDAO iContentDAO;
	
	public void contentAdd(Content content) {
		this.iContentDAO.contentAdd(content);
	}
	
	public void contentDelete(int id){
		this.iContentDAO.contentDelete(id);
	}
	
	public void contentUpdate(Content content){
		this.iContentDAO.contentUpdate(content);
	}
	
	public Content content(int id){
		return this.iContentDAO.content(id);
	}
	
	public List contentList(){
		return this.iContentDAO.contentList();
	}
	
	public List hotContentList(){
		return this.iContentDAO.hotContentList();
	}
	
	public List getCommentNumberList(){
		return this.iContentDAO.getCommentNumberList();
	}
	
	public List getNewContentList(){
		return this.iContentDAO.getNewContentList();
	}
	
	public List contentList(int pageIndex,int pageCount){
		return this.iContentDAO.contentList(pageIndex,pageCount);
	}
	
	public int getPageCount(){
		return this.iContentDAO.getPageCount();
	}

}
