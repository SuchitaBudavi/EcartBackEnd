package com.ecart.dao;

import com.ecart.model.User;

public interface UserDao {
	
	public boolean validateUser(String email, String password);
	
	public User getUser(int uId);
	
	public User getUser(String email);
	
	public void saveOrUpdate(User user);
	
}
