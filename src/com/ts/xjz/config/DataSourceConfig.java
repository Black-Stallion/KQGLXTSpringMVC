package com.ts.xjz.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration				//声明当前类是一个配置类（代替Xml文件）
@ComponentScan("com.ts.xjz")//扫描所有com.ts.xjz包下的类
//通过@PropertySource注解解读jdbc.properties属性文件，ignoreResourceNotFound=true忽略文件找不到的情况
@EnableTransactionManagement//通知Spring，@Transactional注解的类被事务的切面包围。这样@Transactional就可以使用了
@PropertySource(value={"classpath:jdbc.properties"},ignoreResourceNotFound=true)
public class DataSourceConfig {
	@Resource
	private Environment env; //通过@Resource引入环境系统，配合@PropertySource注解，可以直接获取相关 数据
	//@Bean只能注解在含有@Configuration注解的类中使用
	@Resource(name="dataSource")
	private DruidDataSource dataSource;
	
	@Bean(name="dataSource")
	//声明该方法将返回一个bean，Bean将放入容器中备用，druid是alibabab（阿里巴巴）的开源数据缓冲池
	//配置一个数据源
	public DruidDataSource getDruidDataSource(){
		try{
		String className = env.getProperty("jdbc.className");
		String connString = env.getProperty("jdbc.connString");
		String userName=env.getProperty("jdbc.userName");
		String password=env.getProperty("jdbc.password");
		DruidDataSource ds = new DruidDataSource();
		ds.setUrl(connString);
		ds.setDriverClassName(className);
		ds.setUsername(userName);
		ds.setPassword(password);
		ds.setMaxActive(10);
		return ds;
	} catch (Exception e) {
		return null;
	}
	}
	@Bean(name="jdbcTemplate")//配置一个jdbcTemplate并注入一个dataSource数据源
	public JdbcTemplate getJdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}
	//增加事物处理的（直接在Service中调用就行）
	@Bean(name="dataSourceTransactionManager")
	public DataSourceTransactionManager getTxManager(){
		DataSourceTransactionManager transactionManager=new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}
}
