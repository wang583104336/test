package com.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.IAuthDao;
import com.edu.entity.Auth;
import com.edu.service.IAuthService;

@Service
public class AuthService implements IAuthService {

	@Autowired
	private IAuthDao authDao;
	
	@Override
	public List<Auth> findAll() {
		List<Auth> list = null;
		try {
			list = authDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
