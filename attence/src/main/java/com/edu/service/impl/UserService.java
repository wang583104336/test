package com.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.IUserDao;
import com.edu.entity.User;
import com.edu.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public User findByUname(String uname) {
		User user = null;
		if (uname != null) {
			user = userDao.findByUname(uname);
		}
		
		return user;
	}

	@Override
	public void addUser(User user) {
		if (user != null) {
			userDao.addUser(user);
		}
	}
	
	@Override
	public void updatePassword(User user) {
		if (user != null) {
			userDao.updatePassword(user);
		}
	}
	
	@Override
	public void update(User user) {
		if (user != null) {
			userDao.update(user);
		}
	}
}









