package com.hd.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hd.bean.User;
import com.hd.dao.ILoginDAO;
import com.hd.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService {

	@Resource(name="loginDAOImpl")
	private ILoginDAO iLoginDAO;
	
	public int Login(String email, String password) {
		return 0;
	}
	
	public int getUserEmail(String userEmail){
		return this.iLoginDAO.getUserEmail(userEmail);
	}
	
	public String getUserPassword(String userEmail){
		return this.iLoginDAO.getUserPassword(userEmail);
	}
	
	public void register(User u) {
		iLoginDAO.register(u);
	}

}
