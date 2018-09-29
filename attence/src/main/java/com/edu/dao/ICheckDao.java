package com.edu.dao;

import java.util.List;
import java.util.Map;

import com.edu.entity.Check;

public interface ICheckDao {
	
	public int count(int uid);
	
	public List<Check> findByIndexAndSize(Map<String, Object> map);
	
	public void addF(Check check);
	
	public void addL(Check check);
}
