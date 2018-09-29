package com.edu.service;

import com.edu.entity.User;

public interface IUserService {
	
	public User findByUname(String uname);
	
	public void addUser(User user);
	
	public void updatePassword(User user);
	
	public void update(User user);
}
