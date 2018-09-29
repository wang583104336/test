package com.edu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.ICheckDao;
import com.edu.dao.IUserDao;
import com.edu.entity.Check;
import com.edu.entity.User;
import com.edu.service.ICheckService;
import com.edu.vo.PageBean;

@Service
public class CheckService implements ICheckService {
	
	@Autowired
	private ICheckDao checkDao;
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public PageBean<Check> findGradeByPage(int page, int size, String uname) {
		PageBean<Check> pageInfo = new PageBean<>();
		User user = userDao.findByUname(uname);
		
		pageInfo.setPageSize(size);
		pageInfo.setCurrentPage(page);
		
		int count = checkDao.count(user.getId());
		pageInfo.setCount(count);
		
		if (count % size == 0) {
			pageInfo.setTotalPage(count / size); 
		} else {
			pageInfo.setTotalPage(count / size + 1); 
		}
		
		int index = (page - 1) * size;
		Map<String, Object> map = new HashMap<>();
		map.put("id", user.getId());
		map.put("index", index);
		map.put("size", size);
		List<Check> list = checkDao.findByIndexAndSize(map);
		pageInfo.setPageInfos(list);
		
		return pageInfo;
	}

	@Override
	public void addF(Check check) {
		if (check != null) {
			checkDao.addF(check);
		}
	}

}
