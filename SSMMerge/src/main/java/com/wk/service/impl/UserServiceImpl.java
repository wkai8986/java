package com.wk.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wk.dao.IUserDao;
import com.wk.entity.User;
import com.wk.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{

	@Resource
	private IUserDao userDao;

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.selectByPrimaryKey(id);
	}
	
		
	
}
