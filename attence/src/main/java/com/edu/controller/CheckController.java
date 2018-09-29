package com.edu.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.entity.Check;
import com.edu.entity.User;
import com.edu.service.ICheckService;
import com.edu.service.IUserService;
import com.edu.vo.JsonBean;
import com.edu.vo.PageBean;

@Controller
public class CheckController {
	
	@Autowired
	private ICheckService checkService;
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/checkloglist")
	@ResponseBody
	public Map<String, Object> checkLog(int page, int limit, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		String uname = (String) session.getAttribute("uname");
		
		PageBean<Check> pageInfo = checkService.findGradeByPage(page, limit, uname);
		
		map.put("code", 0);  //针对layui的表格，0表示成功
		map.put("msg", "");
		map.put("count", pageInfo.getCount());
		map.put("data", pageInfo.getPageInfos());
		
		return map;
	}
	
	public JsonBean fCheck(HttpSession session) {
		JsonBean bean = new JsonBean();
		String uname = (String) session.getAttribute("uname");
		
		User user = userService.findByUname(uname);
		Check check = new Check();
		check.setUid(user.getId());
		check.setFcreatetime(new Date());
		/*if (check.getFcreatetime().after()) {
			 Calendar cal = Calendar.getInstance();
			 //获得8点时间戳
			 cal.set(Calendar.HOUR_OF_DAY, 8);
			 long t8 = cal.getTimeInMillis();
		}*/
		
		
		return bean;
	}
}










