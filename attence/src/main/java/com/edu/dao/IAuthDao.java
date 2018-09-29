package com.edu.dao;

import java.util.List;

import com.edu.entity.Auth;

public interface IAuthDao {
	
	public List<Auth> findAll();
}
