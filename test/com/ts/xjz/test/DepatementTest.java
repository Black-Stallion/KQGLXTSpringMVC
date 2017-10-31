package com.ts.xjz.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

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
import com.ts.xjz.dao.Att_DepartmentDao;
import com.ts.xjz.entity.Att_AttendanceCollect;
import com.ts.xjz.entity.Att_Employees;
import com.ts.xjz.service.Att_EmployeeService;
import com.ts.xjz.serviceimpl.AttendanceServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {DataSourceConfig.class,MvcConfig.class,WebInitializer.class})
public class DepatementTest {
	@Resource
	JdbcTemplate jt;
	@Resource
	Att_DepartmentDao att_departmentDao;
	@Resource(name="attendanceService")
	AttendanceServiceImpl atts;
	@Resource(name="employeeService")
	Att_EmployeeService es;
	//@Test
	public void TestQueryAll(){
		ArrayList<Map<String,Object>> list = att_departmentDao.findAtt_Department();
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
	//@Test
	public void testemp(){
		ArrayList<Map<String,Object>> list = es.finEmployee();
		for(Map<String,Object> map : list){
			System.out.println(map);
		}
	}
	//@Test
	public void testemp1(){
		ArrayList<Att_Employees> list = es.findEmployess("½¨");
		for(Att_Employees map : list){
			System.out.println(map);
		}
	}
	//@Test
	public void testem3(){
		Att_Employees list = es.findEmployeeByCardID("2013070003");
		System.out.println(list);
	}
	//@Test
	public void testemp2(){
		ArrayList<Map<String,Object>> list = es.findEmployesslist(3,4);
		for(Map<String,Object> map : list){
			System.out.println(map);
		}
	}
	//@Test
	public void testemp4(){
		System.out.println(es.findEmployessCount());
	}
	//@Test
	public void mm(){
		Date date = new Date();
		System.out.println(date);
	}
	@Test
	public void ms(){
		 ArrayList<Att_AttendanceCollect> list = atts.attendanceCollect(2016, 7, 1001);
		 for (Att_AttendanceCollect a : list) {
			System.out.println(a);
		}
	}
}
