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
		//��¼����Ա�Ϳ���Ա��Ȩ�޹���
				HttpServletRequest req = (HttpServletRequest)request;
				HttpServletResponse res = (HttpServletResponse)response;
				PrintWriter  pw = res.getWriter();
				SessionManager.createSession(req);
				if(SessionManager.getAdminRight()==-1){//���ǹ���Ա����Ա
					pw.println("<script>alert('ҳ����Ϣ�ѹ���!,�����µ�¼��');" +
							"window.parent.location.href='/KQGLXTSpringMVC/index.jsp'</script>");
					
				}else{
					if(SessionManager.getAdminRight()==1){
						//���볬���������
						String uri = req.getRequestURI();
						String[] ur = uri.split("/");
						String value = ur[ur.length-1];
						if(value.equals("main.jsp")||value.equals("updatePwd.jsp")|| value.equals("Error.jsp")|| value.equals("PunchCard.jsp")){
							chain.doFilter(request, response);
						}else{
						HashMap<String,Integer> map = SessionManager.getHashMap();
						//Set<String> va = map.keySet();//��ȡ��
						Integer keyValue = map.get(value);//��ȡֵ
								if(1==keyValue){
									chain.doFilter(request, response);
							}else if(0==keyValue){
								pw.println("<script>window.location.href='/KQGLXTSpringMVC/jsp/Error.jsp'</script>");
								//chain.doFilter(request, response);
							}
						}
					}else{
						if(SessionManager.getAdminRight()==0){//���뿼��Ա����,��Ȩ��
							String uri = req.getRequestURI();
							String[] ur = uri.split("/");
							String value = ur[ur.length-1];
							if(value.equals("main.jsp")|| value.equals("updatePwd.jsp")||value.equals("Error.jsp")|| value.equals("PunchCard.jsp")){
								chain.doFilter(request, response);
							}else{
							HashMap<String,Integer> map = SessionManager.getHashMap();
							Integer keyValue = map.get(value);//��ȡֵ
									if(0==keyValue){
										chain.doFilter(request, response);
								}else if(1==keyValue){
									pw.println("<script>window.location.href='/KQGLXTSpringMVC/jsp/Error.jsp'</script>");
									//chain.doFilter(request, response);
								}
							}
						}else{//����Աû��Ȩ�ޣ�ֻ������
							pw.println("<script>alert('����Ȩ�޲��ܽ����ҳ!,�뵽��¼���棡');" +
									"window.parent.location.href='/KQGLXTSpringMVC/index.jsp'</script>");
						}
						
					}
				}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
