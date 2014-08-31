package com.hd.service;

import java.util.List;

import com.hd.bean.Menu;

public interface IMenuService {

	public void menuAdd(Menu menu);
	
	public void menuDelete(int id);
	
	public void menuUpdate(Menu menu);
	
	public List getMenuList();
	
	public List submenuList(int id);
}
