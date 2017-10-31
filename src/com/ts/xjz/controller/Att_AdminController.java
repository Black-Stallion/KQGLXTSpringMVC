package com.ts.xjz.controller;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ts.xjz.entity.Att_Admin;
import com.ts.xjz.service.Att_AdminService;
import com.ts.xjz.util.SessionManager;
@Controller
@RequestMapping("/login")
public class Att_AdminController {
	@Resource(name="att_adminService")
	Att_AdminService att_adminService;
		//@ResponseBody
		@RequestMapping(value="/KQGLXT/{name}")
		public String login(@PathVariable String name,ModelMap model,HttpServletRequest request){
			String adminAccount = request.getParameter("adminAccount");
			String adminPwd = request.getParameter("adminPwd");
			if(adminPwd!=null && !adminPwd.equals("")&& adminAccount!=null && !adminAccount.equals("")){
				Att_Admin admin = att_adminService.loginAdmin(adminAccount, adminPwd);
				if(admin == null){
					model.put("error", "�û��������벻��ȷ������������!");
					return "index";
				}else{
					if(admin.getAdminState()==1){//�˻��Ƿ�����
						//ͨ��SessionManager�࣬ͳһ����Session�������û����ⴴ��Session
						SessionManager.createSession(request);
						SessionManager.setAdminID(admin.getAdminID());
						SessionManager.setAdminRight(admin.getAdminRight());
						SessionManager.setAdminName(admin.getAdminName());
				        return "jsp/main";
						
					}else{
						model.put("error", "�˻��ѱ�����!");
						return "index";
					}
				}
			}else {
				model.put("error", "�û��������벻��ȷ������������!");
				return "index";
			}
		}
		@RequestMapping(value="/exit/{name}")
		public String exit(@PathVariable String name,ModelMap model,HttpServletRequest request){
			SessionManager.setAdminID(-1);
			SessionManager.setAdminRight(-1);
			SessionManager.setAdminName(null);
			return "index";
		}
		@RequestMapping(value = "/update", produces = "text/html;charset=UTF-8")
		public String Pwdupdate(@RequestParam("param") String value, ModelMap map, HttpServletRequest request) {
			if(value.equals("updateP")){
				int adminId = Integer.parseInt(request.getParameter("adminId"));
				Att_Admin admin = att_adminService.findPWD(adminId);
				request.setAttribute("admin", admin);
				return "jsp/updatePwd";
			}else if(value.equals("updatePwd")){
				int adminId = Integer.parseInt(request.getParameter("adminID"));
				String pwd = request.getParameter("newpwd");
				boolean result = att_adminService.updateAdminPWD(pwd, adminId);
				if(result == true){
					System.out.println("�޸ĳɹ� �����µ�¼");
					return "index";
				}else{
					System.out.println("�޸�ʧ�� ��");
					return "jsp/main";
				}
			}
				return "";
		}
}
