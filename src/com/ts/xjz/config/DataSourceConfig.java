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

@Configuration				//������ǰ����һ�������ࣨ����Xml�ļ���
@ComponentScan("com.ts.xjz")//ɨ������com.ts.xjz���µ���
//ͨ��@PropertySourceע����jdbc.properties�����ļ���ignoreResourceNotFound=true�����ļ��Ҳ��������
@EnableTransactionManagement//֪ͨSpring��@Transactionalע����౻����������Χ������@Transactional�Ϳ���ʹ����
@PropertySource(value={"classpath:jdbc.properties"},ignoreResourceNotFound=true)
public class DataSourceConfig {
	@Resource
	private Environment env; //ͨ��@Resource���뻷��ϵͳ�����@PropertySourceע�⣬����ֱ�ӻ�ȡ��� ����
	//@Beanֻ��ע���ں���@Configurationע�������ʹ��
	@Resource(name="dataSource")
	private DruidDataSource dataSource;
	
	@Bean(name="dataSource")
	//�����÷���������һ��bean��Bean�����������б��ã�druid��alibabab������Ͱͣ��Ŀ�Դ���ݻ����
	//����һ������Դ
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
	@Bean(name="jdbcTemplate")//����һ��jdbcTemplate��ע��һ��dataSource����Դ
	public JdbcTemplate getJdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}
	//�������ﴦ��ģ�ֱ����Service�е��þ��У�
	@Bean(name="dataSourceTransactionManager")
	public DataSourceTransactionManager getTxManager(){
		DataSourceTransactionManager transactionManager=new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}
}
