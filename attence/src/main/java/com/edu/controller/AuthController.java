package com.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.entity.Auth;
import com.edu.service.IAuthService;
import com.edu.vo.JsonBean;

@Controller
public class AuthController {
	
	@Autowired
	private IAuthService authService;
	
	@RequestMapping("/authmenu")
	@ResponseBody
	public JsonBean findAll() {
		JsonBean bean = new JsonBean();
		
		List<Auth> list = null;
		
		try {
			list = authService.findAll();
			bean.setCode(1);
			bean.setMsg(list);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		
		return bean;
	}
	
}
