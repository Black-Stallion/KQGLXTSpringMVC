package com.ts.xjz.test;

import java.util.ArrayList;
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
import com.ts.xjz.service.Att_PositionService;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {DataSourceConfig.class,MvcConfig.class,WebInitializer.class})
public class PositonTest {
	@Resource
	JdbcTemplate jt;
	@Resource
	Att_PositionService att_PositionService;
	@Test
	public void test() {
		ArrayList<Map<String,Object>> list = att_PositionService.findAtt_Position();
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}

}
