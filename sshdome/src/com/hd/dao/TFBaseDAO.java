package com.hd.dao;

import java.util.List;

import com.hd.base.IBaseDAO;
import com.hd.bean.TFBase;

/**
 * @author hed
 * Jun 7, 2013
 */
public interface TFBaseDAO extends IBaseDAO{

	public String userLogin(String name,String password);
	
	public List<TFBase> selectAll2();
}
