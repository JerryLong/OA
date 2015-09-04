package com.oa.util;

import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.oa.entity.Privilege;
import com.oa.service.PrivilegeService;

public class InitListener implements ServletContextListener {

	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		PrivilegeService privilegeService = (PrivilegeService) app.getBean("privilegeServiceImpl");
		
		List<Privilege> topPrivilegeList = privilegeService.queryTopList();
		sce.getServletContext().setAttribute("topPrivilegeList",topPrivilegeList);
		Collection<String> allPrivilegeUrl = privilegeService.allPrivilegeUrl();
		sce.getServletContext().setAttribute("allPrivilegeUrl",allPrivilegeUrl);
//		for(String s :allPrivilegeUrl){
//			System.out.println(s);
//		}
//		System.out.println("初始化application！");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
