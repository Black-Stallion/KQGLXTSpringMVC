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

//实现WebApplicationinitizlizer的类都可以在web应用程序启动时被加载
public class WebInitializer implements WebApplicationInitializer{

	@SuppressWarnings("unused")
	public void onStartup(ServletContext servletContext) throws ServletException {
		//该类可以注册配置文件类，该语句实际上是在生产spring的应用程序上下文（容器）
		AnnotationConfigWebApplicationContext configweb = new AnnotationConfigWebApplicationContext();
		//注册DataSourceConfig类和MvcConfig类
		configweb.register(DataSourceConfig.class,MvcConfig.class);
		configweb.setServletContext(servletContext);
		//解决某些乱码问题
		CharsetFilter charserFilter = servletContext.createFilter(CharsetFilter.class);
		//在项目中加载一个spring的filter
		javax.servlet.FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter());
	    characterEncodingFilter.setInitParameter ("encoding","UTF-8");
		characterEncodingFilter.setInitParameter("forceEncoding","true");
		//权限过滤
		PowerFilter PowerFilter = servletContext.createFilter(PowerFilter.class);
		//DispatcherServlet  
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(configweb));
        servlet.addMapping("/");  
        servlet.setLoadOnStartup(1);  
	}
}
