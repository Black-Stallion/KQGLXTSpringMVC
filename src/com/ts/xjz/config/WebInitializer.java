package com.ts.xjz.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.ts.xjz.util.CharsetFilter;
import com.ts.xjz.util.PowerFilter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

//ʵ��WebApplicationinitizlizer���඼������webӦ�ó�������ʱ������
public class WebInitializer implements WebApplicationInitializer{

	@SuppressWarnings("unused")
	public void onStartup(ServletContext servletContext) throws ServletException {
		//�������ע�������ļ��࣬�����ʵ������������spring��Ӧ�ó��������ģ�������
		AnnotationConfigWebApplicationContext configweb = new AnnotationConfigWebApplicationContext();
		//ע��DataSourceConfig���MvcConfig��
		configweb.register(DataSourceConfig.class,MvcConfig.class);
		configweb.setServletContext(servletContext);
		//���ĳЩ��������
		CharsetFilter charserFilter = servletContext.createFilter(CharsetFilter.class);
		//����Ŀ�м���һ��spring��filter
		javax.servlet.FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter());
	    characterEncodingFilter.setInitParameter ("encoding","UTF-8");
		characterEncodingFilter.setInitParameter("forceEncoding","true");
		//Ȩ�޹���
		PowerFilter PowerFilter = servletContext.createFilter(PowerFilter.class);
		//DispatcherServlet  
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(configweb));
        servlet.addMapping("/");  
        servlet.setLoadOnStartup(1);  
	}
}
