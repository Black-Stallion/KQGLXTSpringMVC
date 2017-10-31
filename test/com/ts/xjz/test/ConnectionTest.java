package com.ts.xjz.test;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ts.xjz.config.DataSourceConfig;
import com.ts.xjz.config.MvcConfig;
import com.ts.xjz.config.WebInitializer;
import com.ts.xjz.dao.Att_AdminDao;
import com.ts.xjz.entity.Att_Admin;
import com.ts.xjz.service.Att_AdminService;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {DataSourceConfig.class,MvcConfig.class,WebInitializer.class})
public class ConnectionTest {
	@Resource
	JdbcTemplate jdbcTemplate;
	@Resource
	Att_AdminDao att_adminDao;
	@Resource
	Att_AdminService att_adminService;
	
//	public void test() {
//		//≤È—ØÀ˘”–≤‚ ‘
//		List<Map<String,Object>> list=att_adminDao.queryAll();
//		for(Map<String,Object> map: list){
//			System.out.println(map);
//		}
//	}
	
	//µ«¬º≤‚ ‘
	public void test1(){
		Att_Admin admin = att_adminDao.loginAdmin("zhuzi", "123456");
		System.out.println(admin);
	}
	@Test
	//≤‚ ‘’Àªß
	public void test2(){
		Boolean admin = att_adminService.findAdmin("zhuzi");
		System.out.println(admin);
	}
}
