package com.hd.base;

import java.util.List;

public interface IBaseDAO {
	
	public void add(Object o);
	
	public void deleteById(Class c,int id);
	
	public Object selectObject(Class c,int id);
	
	public List selectByHql(String hql);
	
	public List selectBySql(String sql,String [] args);
	
	public int selectBySql(String sql);
	
	public List getListForPage(final String hql, final int offset,final int length);
}
