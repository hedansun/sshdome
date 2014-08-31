package com.hd.dao;

import com.hd.bean.User;

public interface ILoginDAO {

	public int Login(String email, String password);
	
	public int getUserEmail(String userEmail);
	
	public String getUserPassword(String userEmail);
	
	public void register(User u);
}
