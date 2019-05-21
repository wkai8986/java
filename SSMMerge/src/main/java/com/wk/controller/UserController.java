package com.wk.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wk.entity.User;
import com.wk.service.IUserService;
import com.wk.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Resource
	private IUserService userService;
	
	@RequestMapping(value="/showUser",method=RequestMethod.GET)
	public String to_index1(HttpServletRequest request, Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		System.out.println("userId:"+userId);
		User user = userService.getUserById(userId);
		log.debug(user.toString());
		model.addAttribute("user", user);
		return "showUser";
	}
	
	@RequestMapping(value="/showUser2", method = RequestMethod.GET)
	public String to_Index2(@RequestParam("id") String id,Model model) {
		
		int userId = Integer.parseInt(id);
		System.out.println("userId:"+userId);
		User user = userService.getUserById(userId);
		log.debug(user.toString());
		model.addAttribute("user",user);
		return "showUser";
	}
		
	@RequestMapping("/test")
	public String test(HttpServletRequest request, Model model) {
		
		int userId = Integer.parseInt(request.getParameter("id"));
		System.out.println("userId:" + userId);
		User user = null;
		
		if(userId == 1) {
			user = new User();
			user.setAge(23);
			user.setId(1);
			user.setUsername("wk");
			user.setPassword("0000");
		}
		
		log.debug(user.toString());
		model.addAttribute("user", user);
		return "index";
		
	}
}
