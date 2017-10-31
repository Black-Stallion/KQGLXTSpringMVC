package com.ts.xjz.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(dispatcherTypes={DispatcherType.REQUEST},urlPatterns = { "/jsp/*" })
public class PowerFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//登录管理员和考勤员的权限过滤
				HttpServletRequest req = (HttpServletRequest)request;
				HttpServletResponse res = (HttpServletResponse)response;
				PrintWriter  pw = res.getWriter();
				SessionManager.createSession(req);
				if(SessionManager.getAdminRight()==-1){//不是管理员或考勤员
					pw.println("<script>alert('页面信息已过期!,请重新登录！');" +
							"window.parent.location.href='/KQGLXTSpringMVC/index.jsp'</script>");
					
				}else{
					if(SessionManager.getAdminRight()==1){
						//进入超级管理界面
						String uri = req.getRequestURI();
						String[] ur = uri.split("/");
						String value = ur[ur.length-1];
						if(value.equals("main.jsp")||value.equals("updatePwd.jsp")|| value.equals("Error.jsp")|| value.equals("PunchCard.jsp")){
							chain.doFilter(request, response);
						}else{
						HashMap<String,Integer> map = SessionManager.getHashMap();
						//Set<String> va = map.keySet();//获取键
						Integer keyValue = map.get(value);//获取值
								if(1==keyValue){
									chain.doFilter(request, response);
							}else if(0==keyValue){
								pw.println("<script>window.location.href='/KQGLXTSpringMVC/jsp/Error.jsp'</script>");
								//chain.doFilter(request, response);
							}
						}
					}else{
						if(SessionManager.getAdminRight()==0){//进入考勤员管理,有权限
							String uri = req.getRequestURI();
							String[] ur = uri.split("/");
							String value = ur[ur.length-1];
							if(value.equals("main.jsp")|| value.equals("updatePwd.jsp")||value.equals("Error.jsp")|| value.equals("PunchCard.jsp")){
								chain.doFilter(request, response);
							}else{
							HashMap<String,Integer> map = SessionManager.getHashMap();
							Integer keyValue = map.get(value);//获取值
									if(0==keyValue){
										chain.doFilter(request, response);
								}else if(1==keyValue){
									pw.println("<script>window.location.href='/KQGLXTSpringMVC/jsp/Error.jsp'</script>");
									//chain.doFilter(request, response);
								}
							}
						}else{//考勤员没有权限，只有名字
							pw.println("<script>alert('您无权限不能进入此页!,请到登录界面！');" +
									"window.parent.location.href='/KQGLXTSpringMVC/index.jsp'</script>");
						}
						
					}
				}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
