package com.hd.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.hd.base.impl.BaseDAOImpl;
import com.hd.bean.Menu;
import com.hd.dao.IMenuDAO;

@Repository
public class MenuDAOImpl extends BaseDAOImpl implements IMenuDAO {

	public void menuAdd(Menu menu) {
		this.add(menu);
	}
	
	public void menuDelete(int id){
		this.deleteById(Menu.class, id);
	}
	
	public void menuUpdate(Menu menu){
		this.update(menu);
	}
	
	public List getMenuList(){
		return this.selectByHql("from Menu m where m.pid = 0 order by m.id");
	}
	
	public List submenuList(int id){
		return this.selectByHql(" from Menu m where m.pid="+id+" order by m.id desc");
	}

}
