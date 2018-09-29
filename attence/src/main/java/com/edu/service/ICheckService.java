package com.edu.service;

import com.edu.entity.Check;
import com.edu.vo.PageBean;

public interface ICheckService {
	
	public PageBean<Check> findGradeByPage(int page, int size, String uname);
	
	public void addF(Check check);
	
}
