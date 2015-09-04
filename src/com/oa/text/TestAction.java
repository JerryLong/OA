package com.oa.text;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class TestAction extends ActionSupport{

	ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml",getClass());
	@Override
	public String execute() throws Exception {
		
		
		return SUCCESS;
	}
	
}
