package com.hd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.hd.bean.Menu;
import com.hd.dao.IMenuDAO;
import com.hd.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {

	@Resource(name="menuDAOImpl")
	private IMenuDAO menuDAO;
	
	public void menuAdd(Menu menu) {
		this.menuDAO.menuAdd(menu);
	}
	
	public void menuDelete(int id){
		this.menuDAO.menuDelete(id);
	}
	
	public void menuUpdate(Menu menu){
		this.menuDAO.menuUpdate(menu);
	}
	
	public List getMenuList(){
		return this.menuDAO.getMenuList();
	}
	
	public List submenuList(int id){
		return this.menuDAO.submenuList(id);
	}

}
