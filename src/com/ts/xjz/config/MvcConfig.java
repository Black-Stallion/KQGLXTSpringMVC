package com.ts.xjz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc		//��ʼMVCע�⹦��
public class MvcConfig extends WebMvcConfigurerAdapter{
	//��̬��Դӳ��
	//addResourceHandler()����ָ��URL����URL���Ӿ�̬�ļ�,��Ӧ��addResourceLocation����Ŀ¼����Ӧ�ľ�̬�ļ�
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/");
	}
	@Bean
	//������ͼ���������ڷ����߼���ͼ����ƴװ������ͼ��
	public UrlBasedViewResolver getViewResolver(){
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		resolver.setContentType("text/html;charset=utf-8");
		return resolver;
	}
}
