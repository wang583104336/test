package com.edu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.entity.User;
import com.edu.service.IUserService;
import com.edu.utils.MD5Utils;
import com.edu.vo.JsonBean;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/login2.do")
	@ResponseBody
	public JsonBean login(String uname, String password, HttpSession session) {
		JsonBean bean = new JsonBean();
		try {
			User user = userService.findByUname(uname);
			if (user.getPassword().equals(MD5Utils.getMD5(password))) {
				bean.setCode(1);
				session.setAttribute("uname", uname);
			} else {
				bean.setCode(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			bean.setCode(0);
		}
		return bean;	
	}
	
	@RequestMapping("/register.do")
	@ResponseBody
	public JsonBean register(String uname,int phone,int cardno,String realname,String password) {
		JsonBean bean = new JsonBean();
		User user = new User();
		user.setUname(uname);
		user.setPassword(MD5Utils.getMD5(password));
		user.setPhone(phone);
		user.setCardno(cardno);
		user.setRealname(realname);
		
		try {
			userService.addUser(user);
			bean.setCode(1);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setCode(0);
		}
		
		return bean;
	}
	
	@RequestMapping("/lost.do")
	@ResponseBody
	public JsonBean lost(String uname,String password,int phone,int cardno,String realname) {
		JsonBean bean = new JsonBean();
		User user = userService.findByUname(uname);
		try {
			if (user.getCardno().equals(cardno) 
					&& user.getPhone().equals(phone)
					&& user.getRealname().equals(realname)) {
				user.setPassword(MD5Utils.getMD5(password));
				userService.updatePassword(user);
				bean.setCode(1);
			} else {
				bean.setCode(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
			bean.setCode(0);
		}
		
		return bean;
	}
	
	@RequestMapping("/show.do")
	@ResponseBody
	public JsonBean show(HttpSession session) {
		JsonBean bean = new JsonBean();
		
		String uname = (String) session.getAttribute("uname");
		
		try {
			User user = userService.findByUname(uname);
			bean.setCode(1);
			bean.setMsg(user);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setCode(0);
		}
		
		return bean;
	}
	
	@RequestMapping("/update.do")
	@ResponseBody
	public JsonBean update(String uname,String phone,String cardno,String realname) {
		JsonBean bean = new JsonBean();
		
		User user = new User();
		user.setUname(uname);
		user.setPhone(Integer.parseInt(phone));
		user.setCardno(Integer.parseInt(cardno));
		user.setRealname(realname);
		
		try {
			userService.update(user);
			bean.setCode(1);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setCode(0);
		}
		
		return bean;
	}
}











