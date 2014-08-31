package com.hd.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hd.base.impl.BaseDAOImpl;
import com.hd.bean.User;
import com.hd.dao.ILoginDAO;

@Repository
public class LoginDAOImpl extends BaseDAOImpl implements ILoginDAO {
	
	public int Login(String email, String password){
		return 0;
	}
	
	public int getUserEmail(String userEmail){
		return this.selectBySql("select count(1) from t_user t where t.email='"+userEmail+"'");
	}
	
	public String getUserPassword(String userEmail){
		List l = this.selectBySql("select t.password from t_user t where t.email='"+userEmail+"'", null);
		if(l!=null){
			Map m = (Map) l.get(0);
			return m.get("PASSWORD")+"";
		}
		return "";
	}
	
	public void register(User u){
		this.add(u);
	}
}
