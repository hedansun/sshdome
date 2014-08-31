package com.hd.dao;

import java.util.List;

import com.hd.base.IBaseDAO;
import com.hd.bean.Menu;

public interface IMenuDAO extends IBaseDAO {
	
	public void menuAdd(Menu menu);
	
	public void menuDelete(int id);
	
	public void menuUpdate(Menu menu);
	
	public List getMenuList();
	
	public List submenuList(int id);
}
