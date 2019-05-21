package com.wk.ssmmerge;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.wk.entity.User;
import com.wk.service.IUserService;

//@RunWith(SpringJUnit4ClassRunner.class)    // 表示继承了该类
@ContextConfiguration("classpath:spring-mybatis.xml")
public class Test {

	private static Logger logger = Logger.getLogger(Test.class);
	@Resource
	private  IUserService userService;
//	private ApplicationContext ac = null;

/*
    @Before
	public void before() {
		ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
	    userService = (IUserService)ac.getBean("userService");
	}
*/	
	@org.junit.Test
	public void test() {
		User user = userService.getUserById(1);
		logger.info(JSON.toJSONString(user));
//		logger.info("结果："+ user.getUsername()+"-"+user.getPassword()+"-"+user.getAge());
	}

}
